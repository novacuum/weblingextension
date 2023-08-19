package ch.slackattack.webling.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class MembergroupTest {

  @Test
  void testBuildPath() {
    // Arrange
    Membergroup membergroup = new Membergroup();
    membergroup.setId(123);
    membergroup.setProperties(
      new HashMap<String, String>() {
        {
          put("title", "test");
        }
      }
    );
    membergroup.setParents(new ArrayList<>());

    var membergroupMap = new HashMap<Integer, Membergroup>();
    membergroupMap.put(membergroup.getId(), membergroup);

    assertEquals("test", membergroup.buildPath(membergroupMap));

    Membergroup membergroup2 = new Membergroup();
    membergroup2.setId(456);
    membergroup2.setProperties(
      new HashMap<String, String>() {
        {
          put("title", "test2");
        }
      }
    );
    membergroup2.setParents(Arrays.asList(membergroup.getId()));
    membergroupMap.put(membergroup2.getId(), membergroup2);

    assertEquals("test / test2", membergroup2.buildPath(membergroupMap));

    //test missing parent

    Membergroup membergroup3 = new Membergroup();
    membergroup3.setId(789);
    membergroup3.setProperties(
      new HashMap<String, String>() {
        {
          put("title", "test3");
        }
      }
    );
    membergroup3.setParents(Arrays.asList(100));
    membergroupMap.put(membergroup3.getId(), membergroup3);

    assertEquals("test3", membergroup3.buildPath(membergroupMap));

    //test multiple parents

    membergroup3.setParents(
      Arrays.asList(membergroup.getId(), membergroup2.getId())
    );
    membergroup3.setProperties(
      new HashMap<String, String>() {
        {
          put("title", "test3");
        }
      }
    );

    assertEquals(
      "test / test3 | test / test2 / test3",
      membergroup3.buildPath(membergroupMap)
    );
  }
}
