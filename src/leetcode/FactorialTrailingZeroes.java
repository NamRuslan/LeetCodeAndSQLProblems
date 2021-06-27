package leetcode;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Follow up: Could you write a solution that works in logarithmic time complexity?
 *
 *
 */
public class FactorialTrailingZeroes {
    class Solution {
        public int trailingZeroes(int n) {
            int result = 0;

            while (n > 0) {
                n /= 5;
                result += n;
            }

            return result;
        }
    }
}
