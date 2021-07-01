package leetcode;

/**
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 *
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 *
 * Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfThree {
    class Solution {
        public boolean isPowerOfThree(int n) {

            if (n < 1) return false;

            while (n > 1) {
                if (n % 3 != 0) return false;
                n /= 3;
            }

            return true;
        }
    }

    /**
     * Follow-up question
     */
    class Solution2 {
        public boolean isPowerOfThree(int n) {

            return Integer.toString(n, 3).matches("^10*$");
        }
    }
}
