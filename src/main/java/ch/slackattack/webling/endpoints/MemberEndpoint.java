package ch.slackattack.webling.endpoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import ch.slackattack.webling.api.Client;
import ch.slackattack.webling.api.Membergroup;
import ch.slackattack.webling.endpoints.model.DuplicateMember;
import ch.slackattack.webling.repo.Member;
import ch.slackattack.webling.repo.MemberRepository;
import ch.slackattack.webling.service.ConfigService;
import dev.hilla.Endpoint;
import dev.hilla.Nonnull;

@Endpoint
@AnonymousAllowed
public class MemberEndpoint {
  private MemberRepository repository;
  private ConfigService configService;

  public MemberEndpoint(MemberRepository repository, ConfigService configService) {
    this.repository = repository;
    this.configService = configService;
  }

  public @Nonnull List<@Nonnull Member> findAll() {
    return repository.findAll();
  }

  public @Nonnull List<DuplicateMember> findAllDuplicates(boolean useEmail, boolean useFirstName, boolean useLastName) {
    var all = repository.findAll();
    var duplicates = new HashMap<String, List<Member>>();
    for (Member member : all) {
      String hash = (useFirstName ? member.getFirstName().toLowerCase() : "")
          + (useLastName ? member.getLastName().toLowerCase() : "")
          + (useEmail ? member.getEmail().toLowerCase() : "");

      if (duplicates.keySet().contains(hash)) {
        var list = duplicates.get(hash);
        list.add(member);
      } else {
        var list = new ArrayList<Member>();
        list.add(member);
        duplicates.put(hash, list);
      }
    }

    var response = new ArrayList<DuplicateMember>();

    for (var entry : duplicates.entrySet()) {
      List<Member> value = entry.getValue();
      if (value.size() > 1) {
        response.add(DuplicateMember.createInstanceFromMemberList(value));
      }
    }

    return response;
  }

  public boolean sync() {
    repository.truncateTable();

    // call webling ap
    var config = configService.get();
    Client client = new Client(config.host, config.apiKey);
    Integer[] members = client.getMembers();
    var objectMapper = new ObjectMapper();
    var membergroupMap = new HashMap<Integer, Membergroup>();
    for (Membergroup membergroup : client.getMembergroups()) {
      membergroupMap.put(membergroup.getId(), membergroup);
    }

    for (var entry : membergroupMap.entrySet()) {
      var membergroup = entry.getValue();
      membergroup.buildPath(membergroupMap);
    }

    for (Integer memberId : members) {
      var apiMember = client.getMember(memberId);
      if (apiMember.isValid()) {
        var member = new Member();
        member.setEmail(apiMember.getProperties().getEMail());
        member.setLastName(apiMember.getProperties().getName());
        member.setFirstName(apiMember.getProperties().getVorname());
        member.setDebitors(StringUtils.join(apiMember.getLinks().getDebitor(), ","));

        var memberGroupToPathMap = new HashMap<Integer, String>();
        for (Integer parentId : apiMember.getParents()) {
          memberGroupToPathMap.put(parentId, membergroupMap.get(parentId).getProperties().get("path"));
        }

        try {
          member.setGroups(objectMapper.writeValueAsString(memberGroupToPathMap));
          member.setProperties(objectMapper.writeValueAsString(apiMember.getProperties()));
          member.setId(memberId);
          repository.save(member);
        } catch (JsonProcessingException e) {
          e.printStackTrace();
        }
      }
    }
    return false;
  }
}