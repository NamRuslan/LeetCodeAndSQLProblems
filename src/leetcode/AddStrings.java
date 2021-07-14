package leetcode;

/**
 * Given two non-negative integers, num1 and num2 represented as string,
 * return the sum of num1 and num2 as a string.
 *
 * You must solve the problem without using any built-in library for handling large integers
 * (such as BigInteger).
 * You must also not convert the inputs to integers directly.
 */
public class AddStrings {
    class Solution {
        public String addStrings(String num1, String num2) {

            int n1 = num1.length() - 1, n2 = num2.length() - 1, buff;
            boolean hasOne = false;
            StringBuilder sb = new StringBuilder();

            while (n1 >= -1 || n2 >= -1) {

                buff = hasOne ? 1 : 0;

                if (n1 >= 0) buff += (num1.charAt(n1) - '0');
                if (n2 >= 0) buff += (num2.charAt(n2) - '0');

                if (buff >= 10) {
                    buff %= 10;
                    hasOne = true;
                } else {
                    hasOne = false;
                }

                sb.append(buff);

                n1--;
                n2--;
            }

            if (sb.reverse().charAt(0) == '0') sb.deleteCharAt(0);

            return sb.toString();
        }
    }

    /**
     * More simple solution
     */
    class Solution2 {
        public String addStrings(String num1, String num2) {

            int n1 = num1.length() - 1, n2 = num2.length() - 1, buff = 0;
            StringBuilder sb = new StringBuilder();

            while (n1 >= 0 || n2 >= 0) {
                if (n1 >= 0) buff += (num1.charAt(n1--) - '0');
                if (n2 >= 0) buff += (num2.charAt(n2--) - '0');

                sb.append(buff % 10);

                buff /= 10;
            }

            if (buff > 0) {
                sb.append(buff);
            }

            return sb.reverse().toString();
        }
    }
}
