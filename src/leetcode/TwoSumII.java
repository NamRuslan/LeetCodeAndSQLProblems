package leetcode;

/**
 * Given an array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 *
 * Return the indices of the two numbers (1-indexed) as an integer array answer of size 2,
 * where 1 <= answer[0] < answer[1] <= numbers.length.
 *
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 */
public class TwoSumII {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;
            int[] result = new int[2];

            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    result[0] = ++left;
                    result[1] = ++right;
                    break;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }

            return result;
        }
    }
}
