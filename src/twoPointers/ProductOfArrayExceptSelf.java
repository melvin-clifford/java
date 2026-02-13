package twoPointers;

import java.util.Arrays;

/*
You’re given an integer array, arr. Return a resultant array so that res[i] is equal to the product of all the elements of arr except arr[i].

Constraints:
2 ≤ arr.length ≤ 10^5
-30 ≤ arr[i] ≤ 30
The product of any prefix or suffix of arr is guaranteed to fit in a 32-bit integer.
*/
public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        // Get the length of the input array
        int n = nums.length;

        // Initialize a result array with 1's for products
        int[] res = new int[n];
        Arrays.fill(res, 1);

        // Initialize variables for left and right products
        int leftProduct = 1, rightProduct = 1;

        // Initialize pointers for the left and right ends of the array
        int l = 0, r = n - 1;

        // Iterate through the array while moving the pointers towards each other
        while (l < n && r > -1) {
            // Update the result at the left index with the accumulated left product
            res[l] *= leftProduct;

            // Update the result at the right index with the accumulated right product
            res[r] *= rightProduct;

            // Update the left product with the current element's value
            leftProduct *= nums[l];

            // Update the right product with the current element's value
            rightProduct *= nums[r];

            // Move the left pointer to the right
            l++;

            // Move the right pointer to the left
            r--;
        }

        // Return the final product result array
        return res;
    }

    public static void main(String[] args) {
        int[][] inputList = {
                {1, 5, 10},
                {3, 5, 0, -3, 1},
                {7, 8, 9, 10, 11},
                {2, -4, -8, -11, 11},
                {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 3, 4, 5}
        };

        for (int i = 0; i < inputList.length; i++) {
            System.out.print((i + 1) + ".\tnums: " + Arrays.toString(inputList[i]) +
                    "\n\tres: " + Arrays.toString(productExceptSelf(inputList[i])) + "\n");
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}
