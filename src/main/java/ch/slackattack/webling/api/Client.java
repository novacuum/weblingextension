package ch.slackattack.webling.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

public class Client {

  private Logger logger = LoggerFactory.getLogger(Client.class);
  private String urlPart = ".webling.ch/api/1";
  private String host;
  private String apiKey;
  private RestTemplate restTemplate;

  public Client(String host, String apiKey) {
    this.host = host;
    this.apiKey = apiKey;
    restTemplate = createRestTemplate();
  }

  public Integer[] getMembers() {
    Members members = restTemplate.getForObject(
      getApiUrl("/member"),
      Members.class
    );

    return members == null ? new Integer[0] : members.getObjects();
  }

  public Member getMember(Integer memberId) {
    // String json = restTemplate.getForObject(getApiUrl("/member/" + memberId),
    // String.class);
    // logger.info(json);
    return restTemplate.getForObject(
      getApiUrl("/member/" + memberId),
      Member.class
    );
  }

  public boolean updateDebitor(Integer debitorId, Integer memberId) {
    var headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> request = new HttpEntity<String>(
      "{\"links\":{\"member\":[" + memberId + "]}}",
      headers
    );
    restTemplate.exchange(
      getApiUrl("/debitor/" + debitorId),
      HttpMethod.PUT,
      request,
      Void.class
    );
    return true;
  }

  public Membergroup[] getMembergroups() {
    return restTemplate.getForObject(
      getApiUrl("/membergroup?format=full"),
      Membergroup[].class
    );
  }

  public String getApiUrl(String path) {
    return "https://" + host + urlPart + path;
  }

  protected RestTemplate createRestTemplate() {
    RestTemplate restTemplate = new RestTemplate();

    List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
    interceptors.add(new HeaderRequestInterceptor("apikey", this.apiKey));

    restTemplate.setInterceptors(interceptors);
    return restTemplate;
  }

  private class HeaderRequestInterceptor
    implements ClientHttpRequestInterceptor {

    private final String headerName;

    private final String headerValue;

    public HeaderRequestInterceptor(String headerName, String headerValue) {
      this.headerName = headerName;
      this.headerValue = headerValue;
    }

    @Override
    public ClientHttpResponse intercept(
      HttpRequest request,
      byte[] body,
      ClientHttpRequestExecution execution
    ) throws IOException {
      request.getHeaders().set(headerName, headerValue);
      return execution.execute(request, body);
    }
  }
}
