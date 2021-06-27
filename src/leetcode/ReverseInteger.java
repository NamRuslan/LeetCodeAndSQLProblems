package leetcode;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 */
public class ReverseInteger {
    class Solution {
        public int reverse(int x) {
            String s = String.valueOf(x);
            StringBuilder res = new StringBuilder();
            StringBuilder sec = new StringBuilder();
            sec.append(s);
            if (s.startsWith("-")) {
                sec.deleteCharAt(0);
                res.append(s.charAt(0));
            }
            sec.reverse();
            res.append(sec);
            long result = Long.parseLong(String.valueOf(res));
            if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) result = 0;
            return (int) result;
        }
    }
}
