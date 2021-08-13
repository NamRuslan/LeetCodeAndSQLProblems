package leetcode;

/**
 * You are given an integer array nums consisting of n elements, and an integer k.
 *
 * Find a contiguous subarray whose length is equal to k that has the maximum average value
 * and return this value.
 */
public class MaximumAverageSubarrayI {

static class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int currSum;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        currSum = sum;

        for (int i = k; i < nums.length; i++) {
            currSum += nums[i] - nums[i - k];
            sum = Math.max(currSum, sum);
        }

        return sum / 1.0 / k;
    }
}

}
