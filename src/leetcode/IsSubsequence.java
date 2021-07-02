package leetcode;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed
 * from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 */
public class IsSubsequence {
    class Solution {
        public boolean isSubsequence(String s, String t) {

            if (s.length() > t.length()) return false;
            int j = 0;

            for (int i = 0; i < s.length(); i++) {
                if (j >= t.length()) return false;
                while (s.charAt(i) != t.charAt(j)) {
                    j++;
                    if (j >= t.length()) return false;
                }
                j++;
            }

            return true;
        }
    }

    /**
     * Improved solution
     */
    class Solution2 {
        public boolean isSubsequence(String s, String t) {

            int left = 0;
            for (int i = 0; i < s.length(); i++) {
                left = t.indexOf(s.charAt(i), left);
                if (left == -1) return false;
                left++;
            }

            return true;
        }
    }
}
