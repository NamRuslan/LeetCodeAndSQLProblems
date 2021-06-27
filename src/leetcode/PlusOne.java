package leetcode;

/**
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contains a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 */
public class PlusOne {
    class Solution {
        public int[] plusOne(int[] digits) {
            boolean needExtend = true;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i]++;
                    needExtend = false;
                    break;
                }
            }

            if (needExtend) {
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                return result;
            }

            return digits;
        }
    }
}
