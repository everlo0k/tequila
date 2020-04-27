package cn.bigears.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Solution004
 *
 * @author shenyang
 */
public class Solution4 {

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        final int[] bothArrays = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).sorted().toArray();
        double median;
        final int length = bothArrays.length;
        if (length % 2 == 0) {
            median = (double) (bothArrays[length / 2] + bothArrays[length / 2 - 1]) / 2;
        } else {
            median = (double) bothArrays[length / 2];
        }
        return median;
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        // Deal with invalid corner case.
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return 0.0;

        int m = nums1.length, n = nums2.length;
        // left half of the combined median
        int l = (m + n + 1) / 2;
        // right half of the combined median
        int r = (m + n + 2) / 2;

        // If the nums1.length + nums2.length is odd, the 2 function will return the same number
        // Else if nums1.length + nums2.length is even, the 2 function will return the left number and right number that make up a median
        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
    }

    private static double getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        // This function finds the Kth element in nums1 + nums2

        // If nums1 is exhausted, return kth number in nums2
        if (start1 > nums1.length - 1)
            return nums2[start2 + k - 1];

        // If nums2 is exhausted, return kth number in nums1
        if (start2 > nums2.length - 1)
            return nums1[start1 + k - 1];

        // If k == 1, return the first number
        // Since nums1 and nums2 is sorted, the smaller one among the start point of nums1 and nums2 is the first one
        if (k == 1)
            return Math.min(nums1[start1], nums2[start2]);

        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        if (start1 + k / 2 - 1 < nums1.length)
            mid1 = nums1[start1 + k / 2 - 1];
        if (start2 + k / 2 - 1 < nums2.length)
            mid2 = nums2[start2 + k / 2 - 1];

        // Throw away half of the array from nums1 or nums2. And cut k in half
        if (mid1 < mid2) {
            // nums1.right + nums2
            return getKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            // nums1 + nums2.right
            return getKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 13, 14, 16, 55 };
        int[] nums2 = { 15, 22, 23, 44, 56 };
        System.out.println(Solution4.findMedianSortedArrays1(nums1, nums2));
        System.out.println(Solution4.findMedianSortedArrays2(nums1, nums2));
    }

}
