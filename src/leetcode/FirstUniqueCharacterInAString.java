package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, return the first non-repeating character in it and return its index.
 * If it does not exist, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 *
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 *
 * Input: s = "aabb"
 * Output: -1
 */
public class FirstUniqueCharacterInAString {
    class Solution {
        public int firstUniqChar(String s) {

            char c;

            for (int i = 0; i < s.length(); i++) {
                c = s.charAt(i);
                if (s.indexOf(c) == s.lastIndexOf(c))
                    return s.indexOf(c);
            }

            return -1;
        }
    }

    /**
     * Improved solution
     */
    class Solution2 {
        public int firstUniqChar(String s) {

            Set<Character> set = new HashSet<>();
            char c;

            for (int i = 0; i < s.length(); i++) {
                c = s.charAt(i);
                if (set.contains(c)) continue;
                if (s.indexOf(c) == s.lastIndexOf(c))
                    return s.indexOf(c);
                else
                    set.add(c);
            }

            return -1;
        }
    }
}
