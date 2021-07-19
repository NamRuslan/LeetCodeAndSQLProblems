package leetcode;

/**
 * Given a string s, check if it can be constructed
 * by taking a substring of it and appending multiple copies of the substring together.
 */
public class RepeatedSubstringPattern {
    class Solution {
        public boolean repeatedSubstringPattern(String s) {

            OUTER: for (int size = 1; size <= s.length() / 2; size++) {
                String sub = s.substring(0, size);
                for (int i = 0; i < s.length(); i += size) {
                    if (!s.substring(i, Math.min(s.length(), i + size)).equals(sub)) {
                        continue OUTER;
                    }
                }
                return true;
            }

            return false;
        }
    }

   static class Solution2 {
        public static boolean repeatedSubstringPattern(String s) {
            int size = s.length();
            for (int i = s.length() / 2; i > 0; i--) {
                if (size % i == 0) {
                    String sub = s.substring(0, i);

                    if (sub.repeat(size / i).equals(s)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
