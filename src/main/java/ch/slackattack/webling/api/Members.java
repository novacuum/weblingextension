package ch.slackattack.webling.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Members {
    @JsonProperty("objects")
    private Integer[] objects;

    @JsonProperty("objects")
    public Integer[] getObjects() {
        return objects;
    }

    @JsonProperty("objects")
    public void setObjects(Integer[] objects) {
        this.objects = objects;
    }
}
