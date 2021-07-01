package leetcode;

/**
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return true if n is an ugly number.
 */
public class UglyNumber {
    class Solution {
        public boolean isUgly(int n) {
            int divider = 2;

            if (n < 1) return false;

            while (n > 1) {
                if (n % divider != 0) {
                    if (divider < 3) {
                        divider = 3;
                    } else if (divider < 5) {
                        divider = 5;
                    } else {
                        return false;
                    }
                    continue;
                }

                n /= divider;
            }

            return true;
        }
    }

    /**
     * Improved solution
     */
    class Solution2 {
        public boolean isUgly(int n) {
            if (n < 1) return false;

            for (int divider = 2; divider < 6 && n != 1; divider++) {
                while (n % divider == 0) {
                    n /= divider;
                }
            }

            return n == 1;
        }
    }
}
