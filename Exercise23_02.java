/**
 * Exercise 23.2 - Merge Sort
 *
 * Implement two generic merge sort methods:
 *   1. mergeSort using Comparable
 *   2. mergeSort using Comparator
 *
 * Each mergeSort method needs a corresponding merge helper method.
 *
 * HINT 1 - Generic array creation:
 *   You cannot write: E[] firstHalf = new E[size];
 *   Instead write:    E[] firstHalf = (E[]) new Object[size];
 *
 * HINT 2 - The only comparison change (in your merge method):
 *   int version:        list1[c1] < list2[c2]
 *   Comparable version: list1[c1].compareTo(list2[c2]) < 0
 *   Comparator version: comparator.compare(list1[c1], list2[c2]) < 0
 *
 * HINT 3 - Comparator version:
 *   The comparator must be passed through to the recursive mergeSort calls
 *   AND to the merge helper method.
 */

import java.util.Arrays;
import java.util.Comparator;

public class Exercise23_02 {

    // ---------------------------------------------------------------
    // TODO 1: Implement mergeSort using Comparable
    //
    // Method signature:
    //   public static <E extends Comparable<E>> void mergeSort(E[] list)
    //
    // Steps:
    //   - Base case: if list.length <= 1, return (already sorted)
    //   - Create firstHalf: (E[]) new Object[list.length / 2]
    //   - Copy first half from list using System.arraycopy
    //   - Create secondHalf: (E[]) new Object[list.length - list.length / 2]
    //   - Copy second half from list using System.arraycopy
    //   - Recursively call mergeSort on firstHalf and secondHalf
    //   - Call merge(firstHalf, secondHalf, list)
    // ---------------------------------------------------------------


    // ---------------------------------------------------------------
    // TODO 2: Implement merge helper for Comparable version
    //
    // Method signature:
    //   private static <E extends Comparable<E>>
    //   void merge(E[] list1, E[] list2, E[] temp)
    //
    // Steps:
    //   - Three pointers: current1=0, current2=0, current3=0
    //   - While both lists have elements:
    //       if list1[current1].compareTo(list2[current2]) < 0
    //           take from list1
    //       else
    //           take from list2
    //   - Copy any remaining elements from list1
    //   - Copy any remaining elements from list2
    // ---------------------------------------------------------------


    // ---------------------------------------------------------------
    // TODO 3: Implement mergeSort using Comparator
    //
    // Method signature:
    //   public static <E> void mergeSort(E[] list, Comparator<? super E> comparator)
    //
    // Same structure as TODO 1, but:
    //   - Pass comparator to both recursive mergeSort calls
    //   - Pass comparator to the merge call
    // ---------------------------------------------------------------


    // ---------------------------------------------------------------
    // TODO 4: Implement merge helper for Comparator version
    //
    // Method signature:
    //   private static <E>
    //   void merge(E[] list1, E[] list2, E[] temp, Comparator<? super E> comparator)
    //
    // Same structure as TODO 2, but use:
    //   comparator.compare(list1[current1], list2[current2]) < 0
    // ---------------------------------------------------------------


    public static void main(String[] args) {

        // --- Test 1: mergeSort with Comparable ---
        String[] names1 = {"Maria", "Alex", "Jordan", "Beth", "Chris"};
        System.out.println("Before merge sort (Comparable): " + Arrays.toString(names1));
        mergeSort(names1);
        System.out.println("After  merge sort (Comparable): " + Arrays.toString(names1));
        System.out.println();

        // --- Test 2: mergeSort with Comparator (by length) ---
        String[] names2 = {"Maria", "Al", "Jordan", "Beth", "Christopher"};
        Comparator<String> byLength = Comparator.comparingInt(String::length);
        System.out.println("Before merge sort (Comparator - by length): " + Arrays.toString(names2));
        mergeSort(names2, byLength);
        System.out.println("After  merge sort (Comparator - by length): " + Arrays.toString(names2));
        System.out.println();

        // --- Test 3: larger Integer array ---
        Integer[] numbers = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Before merge sort (Comparable): " + Arrays.toString(numbers));
        mergeSort(numbers);
        System.out.println("After  merge sort (Comparable): " + Arrays.toString(numbers));
        System.out.println();

        // --- Test 4: reverse order with Comparator ---
        Integer[] numbers2 = {38, 27, 43, 3, 9, 82, 10};
        Comparator<Integer> reverseOrder = Comparator.reverseOrder();
        System.out.println("Before merge sort (Comparator - reverse): " + Arrays.toString(numbers2));
        mergeSort(numbers2, reverseOrder);
        System.out.println("After  merge sort (Comparator - reverse): " + Arrays.toString(numbers2));
        System.out.println();

        // --- Test 5: single element (base case) ---
        Integer[] single = {42};
        System.out.println("Single element: " + Arrays.toString(single));
        mergeSort(single);
        System.out.println("After merge sort: " + Arrays.toString(single));
    }
}
