package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    class Solution {
        public int longestPalindrome(String s) {

            Map<Character, Integer> map = new HashMap<>();
            int result = 0, odd = 0;

            for (int i = 0; i < s.length(); i++) {

                char ch = s.charAt(i);

                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);

                } else {
                    map.put(ch, 1);
                }
            }

            for (int i : map.values()) {
                if (i % 2 == 0) {
                    result += i;
                } else {
                    result += i - 1;
                    odd = 1;
                }
            }

            return result + odd;
        }
    }

    /**
     * Improved solution
     */
    class Solution2 {
        public int longestPalindrome(String s) {
            int[] map = new int[128];
            int result = 0, odd = 0;

            for (int i = 0; i < s.length(); i++) {
                map[s.charAt(i)]++;
            }

            for (int i : map) {
                if (i % 2 == 0) {
                    result += i;
                } else if (i > 1) {
                    result += i - 1;
                    odd = 1;
                }
            }

            return result + odd;
        }
    }
}
