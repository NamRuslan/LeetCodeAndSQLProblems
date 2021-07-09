package leetcode;
/**
 * Given an integer num, return a string representing its hexadecimal representation.
 * For negative integers, two’s complement method is used.
 *
 * All the letters in the answer string should be lowercase characters,
 * and there should not be any leading zeros in the answer except for the zero itself.
 *
 * Note: You are not allowed to use any built-in library method to directly solve this problem.
 */
public class ConvertANumberToHexadecimal {

    class Solution {
        public String toHex(int num) {

            char[] map = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            StringBuilder sb = new StringBuilder();

            if (num >= 0) {
                do {
                    sb.append(map[num % 16]);
                    num /= 16;
                } while (num > 0);

            } else {
                num += 1;

                for (int i = 0; i < 8; i++) {
                    if (num < 0) {
                        sb.append(map[num % 16 + 15]);
                        num /= 16;
                    } else {
                        sb.append('f');
                    }
                }
            }

            return sb.reverse().toString();
        }
    }
}
