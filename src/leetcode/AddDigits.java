package leetcode;

/**
 * Given an integer num,
 * repeatedly add all its digits until the result has only one digit, and return it.
 */
public class AddDigits {
    class Solution {
        public int addDigits(int num) {

            int result = 0;

            while (num > 0) {
                result += num % 10;
                num /= 10;

                if (num == 0 && result > 9) {
                    num = result;
                    result = 0;
                }
            }

            return result;
        }
    }
}
