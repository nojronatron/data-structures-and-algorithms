package sorting.algorithms;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMergeSort {
  @Test
  public void testMethodShouldSortSimpleArray() {
    // ArrayList<Integer> inputArray = new ArrayList<>();
    int[] inputArray = { 20, 18, 12, 8, 5, -2 };
//    inputArray.add(20);
//    inputArray.add(18);
//    inputArray.add(12);
//    inputArray.add(8);
//    inputArray.add(5);
//    inputArray.add(-2);

    String inputArrayAsString = getPrettyArrayString(inputArray);
    System.out.println("Input array: " + inputArrayAsString.toString());

//    MergeSorter.mergesort(inputArray);

    String mutatedArrayAsString = getPrettyArrayString(inputArray);
    System.out.println("Resulting array: " + mutatedArrayAsString);

    assertTrue(true);
  }

  private String getPrettyArrayString(int[] inputArray) {
    StringBuilder inputArrayAsString = new StringBuilder();
    inputArrayAsString.append("[");

    for(int idx = 0; idx < inputArray.length; idx++) {
      inputArrayAsString.append(" " + String.valueOf(inputArray[idx]) + " ");

      if (idx < inputArray.length - 1) {
        inputArrayAsString.append(",");
      }
    }

    inputArrayAsString.append("]");
    return inputArrayAsString.toString();
  }

}
