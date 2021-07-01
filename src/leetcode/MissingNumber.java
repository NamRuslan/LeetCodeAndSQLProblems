package leetcode;

/**
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 *
 * Follow up: Could you implement a solution using only O(1) extra space complexity
 * and O(n) runtime complexity?
 */
public class MissingNumber {
    /**
     * Done according follow-up question
     */
    class Solution {
        public int missingNumber(int[] nums) {
            int sum = ((nums.length + 1) * nums.length) / 2;

            for (int i : nums) {
                sum -= i;
            }

            return sum;
        }
    }
}
