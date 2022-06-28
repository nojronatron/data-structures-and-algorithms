package sorting.algorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestInsertingSorter {

  /*
  []

For your own understanding, consider also stepping through these inputs:

Reverse-sorted: []
Few uniques: []
Nearly-sorted: []
   */
  protected ArrayList<Integer> noValues = new ArrayList<>();
  protected int[] singleValue = { 11 };
  protected int[] alphaArray = {8,4,23,42,16,15};
  protected int[] alphaArrayResult = { 4, 8, 15, 16, 23, 42 };

  protected int[] reversedArray = {20,18,12,8,5,-2};
  protected int[] reversedArrayResult = {-2, 5, 8, 12, 18, 20};

  protected int[] fewUniquesArray ={5,12,7,5,5,7};
  protected int[] fewUniquesArrayResult = {5, 5, 5, 7, 7, 12};

  protected int[] nearlySortedArray = {2,3,5,7,13,11};
  protected int[] nearlySortedArrayResult = {2, 3, 5, 7, 11, 13};

  protected int[] negativesInArray = { -5, 6, -7, 8, 7, 3 };
  protected int[] negativesInArrayResult = { -7, -5, 3, 6, 7, 8};

  protected int[] zeroInArray = { 5, 6, 7, 8, 0, 3 };
  protected int[] zeroInArrayResult = { 0, 3, 5, 6, 7, 8};

  @Test
  public void testMethodShouldAcceptEmptyInputWithoutError() {
  InsertionSorter.insertionSort(noValues);
  }

  @Test
  public void testMethodShouldAcceptSingleElementArrayWithoutError() {

  }

  @Test
  public void testShouldSortArrayWithDescendingValuesToAscendingValuesArray() {

  }

  @Test
  public void testArrayOfUnsortedIntegersIsSortedInAscendingOrder() {
    ArrayList<Integer> inputData = new ArrayList<>();

    for(Integer element: alphaArray) {
      inputData.add(element);
    }

    ArrayList<Integer> expectedResults = new ArrayList<>();

    for (int idx=0; idx <= alphaArrayResult.length; idx++) {
      expectedResults.add(alphaArrayResult[idx] );
    }

    InsertionSorter.insertionSort(inputData);

    assertEquals(expectedResults.size(), inputData.size(), "Input and result array should not change size.");

    for(int idx=0; idx <= inputData.size(); idx++) {
      assertEquals(expectedResults.get(idx), inputData.get(idx),
        "Each element should be in correct index resulting in an ascending-order array.");
    }

    assertTrue(true);
  }


}
