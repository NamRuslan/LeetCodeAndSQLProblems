package leetcode;

/**
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a
 * cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 */
public class HappyNumber {
    class Solution {

        public boolean isHappy(int n) {
            if (n == 4) return false;

            int sum = 0;
            int sumBuff;

            while (n > 0) {
                sum += (int) Math.pow(n % 10, 2);
                n /= 10;
            }

            sumBuff = sum;

            while (sum != 1) {
                if (sum % 10 != 0) {
                    return isHappy(sumBuff);
                }
                sum /= 10;
            }

            return true;
        }
    }
}
