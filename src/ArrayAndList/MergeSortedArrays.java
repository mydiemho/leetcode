package ArrayAndList;

import java.util.Arrays;

/**
 * Created by myho on 7/1/15.
 */

//https://leetcode.com/problems/merge-sorted-array/

public class MergeSortedArrays {

    // strategy, move largest number to the right
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        // pointer to where we are in respect to the arrays.
        int index1 = m - 1;
        int index2 = n - 1;

        // move from right to left
        int insertIndex = m + n - 1;

        while (index1 >= 0 && index2 >= 0) {
            nums1[insertIndex--] = nums1[index1] >= nums2[index2] ? nums1[index1--] : nums2[index2--];
        }

        // all items in nums1 that are greater than nums2 has been moved, just append
        // the rest of nums2 to the left.
        while(index2 >= 0) {
            nums1[insertIndex--] = nums2[index2--];
        }
}

    public static void main(String[] args) {
        int[] n1 = new int[10];
        n1[0] = 2;

        int[] n2 = new int[]{1};

        System.out.println(Arrays.toString(n1));
        merge(n1, 1, n2, 1);
        System.out.println(Arrays.toString(n1));

    }


}
