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

  @Test(timeout = 500)
public void testMergeWithDuplicatesInBothLists() {
  List<String> left = Arrays.asList("a", "b", "c", "e");
  List<String> right = Arrays.asList("a", "d", "e");
  List<String> merged = ListExamples.merge(left, right);
  List<String> expected = Arrays.asList("a", "a", "b", "c", "d", "e", "e");
  assertEquals(expected, merged);
}

@Test
public void testMergeAllUnique() {
  List<String> left = Arrays.asList("b", "c", "e");
  List<String> right = Arrays.asList("a", "d", "f");
  List<String> merged = ListExamples.merge(left, right);
  List<String> expected = Arrays.asList("a", "b", "c", "d", "e", "f");
  assertEquals(expected, merged);
}

@Test
public void testFilterWithMatchingElements() {
  List<String> list = Arrays.asList("moon", "star", "planet", "moon");
  List<String> filtered = ListExamples.filter(list, new IsMoon());
  List<String> expected = Arrays.asList("moon", "moon");
  assertEquals(expected, filtered);
}

@Test
public void testFilterNoMatchingElements() {
  List<String> list = Arrays.asList("sun", "star", "planet");
  List<String> filtered = ListExamples.filter(list, new IsMoon());
  List<String> expected = Arrays.asList();
  assertEquals(expected, filtered);
}

@Test
public void testMergeWithEmptyAndNonEmptyList() {
  List<String> left = Arrays.asList();
  List<String> right = Arrays.asList("a", "d");
  List<String> merged = ListExamples.merge(left, right);
  List<String> expected = Arrays.asList("a", "d");
  assertEquals(expected, merged);
}

@Test
public void testMergeTwoEmptyLists() {
  List<String> left = Arrays.asList();
  List<String> right = Arrays.asList();
  List<String> merged = ListExamples.merge(left, right);
  List<String> expected = Arrays.asList();
  assertEquals(expected, merged);
}

@Test
public void testFilterEmptyList() {
  List<String> list = Arrays.asList();
  List<String> filtered = ListExamples.filter(list, new IsMoon());
  List<String> expected = Arrays.asList();
  assertEquals(expected, filtered);
} 
}
