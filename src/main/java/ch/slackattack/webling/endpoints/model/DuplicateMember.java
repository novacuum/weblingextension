package ch.slackattack.webling.endpoints.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import ch.slackattack.webling.repo.Member;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DuplicateMember {
    private Member main;

    private List<Member> duplicates;

    public static DuplicateMember createInstanceFromMemberList(List<Member> members) {
        var instance = new DuplicateMember();
        instance.setMain(members.get(0));
        instance.setDuplicates(members);
        return instance;
    }

    public Member getMain() {
        return main;
    }

    public void setMain(Member main) {
        this.main = main;
    }

    public List<Member> getDuplicates() {
        return duplicates;
    }

    public void setDuplicates(List<Member> duplicates) {
        this.duplicates = duplicates;
    }
}
