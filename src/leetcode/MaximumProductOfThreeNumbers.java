package leetcode;

import java.util.Arrays;

/**
 * Given an integer array nums,
 * find three numbers whose product is maximum and return the maximum product.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: 6
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: 24
 *
 * Example 3:
 *
 * Input: nums = [-1,-2,-3]
 * Output: -6
 */
public class MaximumProductOfThreeNumbers {
static class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int n1 = nums[0] * nums[1] * nums[nums.length - 1];
        int n2 = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];

        return Math.max(n1, n2);
    }
}

/**
 * Improved solution simply based on previous
 */
static class Solution2 {
    public int maximumProduct(int[] nums) {
        int max = Integer.MIN_VALUE,
            mid = Integer.MIN_VALUE,
            min = Integer.MIN_VALUE,
            negMax = Integer.MAX_VALUE,
            negMin = Integer.MAX_VALUE;

        for (int i : nums) {
            if (i >= max) {
                min = mid;
                mid = max;
                max = i;
            } else if (i >= mid) {
                min = mid;
                mid = i;
            } else if (i > min) {
                min = i;
            }

            if (i <= negMax) {
                negMin = negMax;
                negMax = i;
            } else if (i <= negMin) {
                negMin = i;
            }


        }

        return Math.max(max * mid * min, max * negMin * negMax);
    }
}

}
