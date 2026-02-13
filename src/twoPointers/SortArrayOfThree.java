package twoPointers;

import java.util.*;

public class SortArrayOfThree {
    /**
     * Sort int array with only 3 values of 0,1,2
     *
     * @param arr int array
     * @return sorted int array
     */
    public static int[] sortArray(int[] arr) {
        // Initialize the start, current, and end pointers
        int start = 0;
        int current = 0;
        int end = arr.length - 1;

        // Iterate through the list until the current pointer exceeds the end pointer
        while (current <= end) {
            if (arr[current] == 0) {
                // If the current element is 0, swap it with the element at the start pointer
                int temp = arr[start];
                arr[start] = arr[current];
                arr[current] = temp;

                // Move both the start and current pointers one position forward
                current++;
                start++;
            }

            else if (arr[current] == 1) {
                // If the current element is 1, just move the current pointer one position forward
                current++;
            }

            else {
                // If the current element is 2, swap it with the element at the end pointer
                int temp = arr[current];
                arr[current] = arr[end];
                arr[end] = temp;

                // Move the end pointer one position backward
                end--;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {0, 1, 0},
                {1, 1, 0, 2},
                {2, 1, 1, 0, 0},
                {2, 2, 2, 0, 1, 0},
                {2, 1, 1, 0, 1, 0, 2}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tarray: " + Arrays.toString(inputs[i]));
            int[] sortedArray = sortArray(inputs[i].clone());
            System.out.println("\n\tThe sorted array is: " + Arrays.toString(sortedArray));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}
