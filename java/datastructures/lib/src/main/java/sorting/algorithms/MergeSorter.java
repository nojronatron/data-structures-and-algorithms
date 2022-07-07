package sorting.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class MergeSorter {
  public static void mergesort(int[] arr) {

    int n = arr.length;

    if (n > 1) {

      int mid = n / 2;

      int[] left = Arrays.copyOfRange(arr, 0, mid); //arr.subList(0, mid);

      int[] right = Arrays.copyOfRange(arr, mid, arr.length); //arr.subList(mid, n);

      mergesort(left);

      mergesort(right);

      merge(left, right, arr);
    }

  }

  public static void merge(int[] left, int[] right, int[] arr) {
    int i = 0;
    int j = 0;
    int k = 0;

    while (i < left.length && j < right.length) {

      // TODO: fix array index out of bounds error somewhere in this method
      if (left[i] <= right[j]) {
        // int kTemp = left.get(i);
        int kTemp = Integer.valueOf(left[i]);
        arr[k] = kTemp; // arr.set(k, left.get(i));
        // arr.set(k, kTemp);

        i++;
      } else {
        // int kTemp = right.get(j);
        // arr.set(k, right.get(j));
        int kTemp = Integer.valueOf(left[j]);
        arr[k] = kTemp; //arr.set(k, kTemp);
        j++;
      }

      k++;
    }

    if (i == left.length) {
      // set remaining entries in arr to remaining values in right
      for (int idx=k; idx < arr.length; idx++) {
        arr[idx] = right[j]; // arr.set(idx, Integer.valueOf(right.get(j))); //right.get(j));
        j++;
//        arr.set(idx, rightArrayItemValue);
      }
    } else {
      for (int jdx=k; jdx < arr.length; jdx++) {
        // arr.set(jdx, Integer.valueOf(left.get(k))); //left.get(k));
        arr[jdx] = left[i];
        k++;
//        arr.set(jdx, leftArrayItemValue);
      }
    }
  }
}

//    if (i == left.size()) {
//      // set remaining entries in arr to remaining values in right
//      // from https://code-maze.com/csharp-merge-sort/
//      k++;
//
//      while (i < left.size()) {
//        i++;
//        arr.set(k, left.get(i));
//      }
//
//      while (j < right.size()) {
//        // set remaining entries in arr to remaining values in left
//        j++;
//        arr.set(k, right.get(j));
//      }
//    }
