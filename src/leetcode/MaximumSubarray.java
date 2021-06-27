package leetcode;

/**
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 */
public class MaximumSubarray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0];
            int current = 0;

            for (int i : nums) {

                if (current < 0) {
                    current = 0;
                }

                current += i;

                if (current > max) {
                    max = current;
                }
            }

            return max;
        }
    }
}
