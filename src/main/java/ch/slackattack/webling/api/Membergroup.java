package ch.slackattack.webling.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
  { "type", "readonly", "properties", "children", "parents", "links" }
)
public class Membergroup {

  @JsonProperty("type")
  private String type;

  @JsonProperty("readonly")
  private boolean readonly;

  @JsonProperty("properties")
  private Map<String, String> properties;

  @JsonProperty("parents")
  private List<Integer> parents;

  @JsonProperty("id")
  private Integer id;

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
  public Map<String, String> getProperties() {
    return properties;
  }

  @JsonProperty("properties")
  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }

  @JsonProperty("parents")
  public List<Integer> getParents() {
    return parents;
  }

  @JsonProperty("parents")
  public void setParents(List<Integer> parents) {
    this.parents = parents;
  }

  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Integer id) {
    this.id = id;
  }

  public String buildPath(Map<Integer, Membergroup> membergroupMap) {
    if (properties.keySet().contains("path")) {
      return properties.get("path");
    }

    var title = properties.get("title");

    var pathParts = new ArrayList<String>();
    for (Integer parent : parents) {
      if (membergroupMap.containsKey(parent)) {
        pathParts.add(
          membergroupMap.get(parent).buildPath(membergroupMap) + " / " + title
        );
      }
    }

    if (pathParts.isEmpty()) {
      properties.put("path", title);
      return title;
    }

    String path = StringUtils.join(pathParts, " | ");
    properties.put("path", path);
    return path;
  }
}
