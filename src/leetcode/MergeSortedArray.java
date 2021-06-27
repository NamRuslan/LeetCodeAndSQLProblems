package leetcode;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function,
 * but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class MergeSortedArray {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (n == 0) return;
            int a = 0;
            int b = 0;
            int[] result = new int[nums1.length];
            for (int i = 0; i < result.length; i++) {
                if (b == nums2.length) {
                    result[i] = nums1[a];
                    a++;
                }else if (nums1[a] < nums2[b] && a < (nums1.length - nums2.length)) {
                    result[i] = nums1[a];
                    a++;
                } else {
                    result[i] = nums2[b];
                    b++;
                }
            }

            System.arraycopy(result, 0, nums1, 0, result.length);
        }
    }
}
