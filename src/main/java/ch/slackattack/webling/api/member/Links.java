package ch.slackattack.webling.api.member;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Links {
    @JsonProperty("debitor")
    private List<Integer> debitor;

    @JsonProperty("debitor")
    public List<Integer> getDebitor() {
        return debitor;
    }

    @JsonProperty("debitor")
    public void setDebitor(List<Integer> debitor) {
        this.debitor = debitor;
    }
}