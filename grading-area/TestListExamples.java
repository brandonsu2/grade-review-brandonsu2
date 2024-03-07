import static org.junit.Assert.*;
import org.junit.*;

import java.beans.Transient;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  
  // @Before
  // public void setUp() throws Exception {
  //   List<String> left = Arrays.asList("a", "b", "c");
  //   List<String> right = Arrays.asList("a", "d");
  //   List<String> emptyList = Arrays.asList();
  // }

  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test
  public void testMergeLeftEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> emptyList = Arrays.asList();
    List<String> merged = ListExamples.merge(right, left);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test
  public void testMergeEmptyList(){
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> emptyList = Arrays.asList();
    List<String> merged = ListExamples.merge(right, emptyList);
    List<String> expected = right;
    assertEquals(expected, merged);
  }

  @Test
  public void testFilter() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> emptyList = Arrays.asList();
    List<String> filtered = ListExamples.filter(left, new IsMoon());
    List<String> expected = Arrays.asList();
    assertEquals(expected, filtered);
  }
}
