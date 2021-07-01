package leetcode;

import java.util.Arrays;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */
public class ValidAnagram {
    class Solution {
        public boolean isAnagram(String s, String t) {

            if (s.length() != t.length()) return false;

            char[] sArr, tArr;

            sArr = s.toCharArray();
            tArr = t.toCharArray();

            Arrays.sort(sArr);
            Arrays.sort(tArr);

            for (int i = 0; i < s.length(); i++) {
                if (sArr[i] != tArr[i]) return false;
            }

            return true;
        }
    }

    /**
     * Improved solution(3ms)
     */
    class Solution2 {
        public boolean isAnagram(String s, String t) {

            if (s.length() != t.length()) return false;

            int[] map = new int[26];

            for (int i = 0; i < s.length(); i++) {
                ++map[s.charAt(i) - 'a'];
                --map[t.charAt(i) - 'a'];
            }

            for (int i : map) {
                if (i != 0) return false;
            }

            return true;
        }
    }

    /**
     * Improved solution(1ms)
     */
    class Solution3 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;

            int[] map = new int[128];

            for (char ch : s.toCharArray()) {
                ++map[ch];
            }

            for (char ch : t.toCharArray()) {
                --map[ch];
                if (map[ch] < 0) return false;
            }

            return true;
        }
    }
}
