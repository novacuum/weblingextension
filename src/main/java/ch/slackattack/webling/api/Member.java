package ch.slackattack.webling.api;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import ch.slackattack.webling.api.member.Children;
import ch.slackattack.webling.api.member.Links;
import ch.slackattack.webling.api.member.Properties;

// https://www.jsonschema2pojo.org/

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "readonly",
        "properties",
        "children",
        "parents",
        "links"
})
public class Member {

    @JsonProperty("type")
    private String type;
    @JsonProperty("readonly")
    private boolean readonly;
    @JsonProperty("properties")
    private Properties properties;
    @JsonProperty("children")
    private Children children;
    @JsonProperty("parents")
    private List<Integer> parents;
    @JsonProperty("links")
    private Links links;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("readonly")
    public boolean isReadonly() {
        return readonly;
    }

    @JsonProperty("readonly")
    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
    }

    @JsonProperty("properties")
    public Properties getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @JsonProperty("children")
    public Children getChildren() {
        return children;
    }

    @JsonProperty("children")
    public void setChildren(Children children) {
        this.children = children;
    }

    @JsonProperty("parents")
    public List<Integer> getParents() {
        return parents;
    }

    @JsonProperty("parents")
    public void setParents(List<Integer> parents) {
        this.parents = parents;
    }

    @JsonProperty("links")
    public Links getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(Links links) {
        this.links = links;
    }

    public boolean isValid() {
        return this.properties != null
                && this.properties.getName() != null
                && this.properties.getVorname() != null
                && this.properties.getEMail() != null;
    }

}