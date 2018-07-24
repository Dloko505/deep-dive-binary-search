package edu.cnm.deepdive;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {
    Random rng = new Random();
    int[] haystack = IntStream.generate(() -> rng.nextInt()).limit(1_000_000).toArray();
    int[] needles = IntStream.generate(() -> rng.nextInt()).limit(10_000).toArray();
    long start = System.currentTimeMillis();
    for (int needle : needles) {
      Search.linearSearch(haystack, needle);
    }
    System.out.printf("Linear search for %,d needles in a haystack of size %,d = %.2f%n",
        needles.length, haystack.length, (System.currentTimeMillis() - start) / 1000d);
    start = System.currentTimeMillis();
    Arrays.sort(haystack);

    System.out.printf("Sort time for a haystack %,d = %.2f%n",
        haystack.length, (System.currentTimeMillis() - start) / 1000d);
    start = System.currentTimeMillis();
    for (int needle : needles) {
      Search.binarySearch(haystack, needle);
    }
    System.out.printf("Binary search for %,d needles in a haystack of size %,d = %.2f%n",
        needles.length, haystack.length, (System.currentTimeMillis() - start) / 1000d);
  }
}
