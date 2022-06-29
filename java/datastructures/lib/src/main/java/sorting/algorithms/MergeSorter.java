package sorting.algorithms;

import java.util.ArrayList;

public class MergeSorter {
  public void mergesort(ArrayList<Integer> arr) {

    int n = arr.size();

    if (n > 1) {

      int mid = n / 2;

      ArrayList<Integer> left = (ArrayList<Integer>) arr.subList(0, mid - 1);

      ArrayList<Integer> right = (ArrayList<Integer>) arr.subList(mid, n - 1);

      mergesort(left);

      mergesort(right);

      merge(left, right, arr);
    }

  }

  public void merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> arr) {
    int i = 0;
    int j = 0;
    int k = 0;

    while (i < left.size() && j < right.size()) {

      if (left.get(i) <= right.get(j)) {
        arr.set(k, left.get(i));
        i++;
      } else {
        arr.set(k, right.get(i));
        j++;
      }

      k++;
    }

    if (i == left.size()) {
      // set remaining entries in arr to remaining values in right
      // from https://code-maze.com/csharp-merge-sort/
      k++;

      while (i < left.size()) {
        i++;
        arr.set(k, left.get(i));
      }

      while (j < right.size()) {
        // set remaining entries in arr to remaining values in left
        j++;
        arr.set(k, right.get(j));
      }
    }
  }
}
