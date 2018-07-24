package edu.cnm.deepdive;

public class Search {

  public static  int linearSearch(int[] haystack, int needle) {
    for (int i = 0; i < haystack.length; i++) {
      if (haystack[i] == needle) {
        return i;
      }
    }
    return -1;
  }

  public static int binarySearch(int[] haystack, int needle) {
    return binarySearch(haystack, needle, 0, haystack.length);
  }

  public static int binarySearch(int[] haystack, int needle, int from, int to) {
    if (to <= from) {
      return -(from + 1);
    }
    int pivot = (from + to) / 2;
    int testValue = haystack[pivot];
    if (needle < testValue) {
      return binarySearch(haystack, needle, from, pivot);
    } else if (needle > testValue) {
      return binarySearch(haystack, needle, pivot + 1, to);
    } else {
      return pivot;
    }
  }
}