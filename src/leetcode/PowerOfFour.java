package leetcode;

/**
 * Given an integer n, return true if it is a power of four. Otherwise, return false.
 *
 * An integer n is a power of four, if there exists an integer x such that n == 4x.
 */
public class PowerOfFour {
    class Solution {
        public boolean isPowerOfFour(int n) {

            return Integer.toString(n, 4).matches("^10*$");
        }
    }
}
