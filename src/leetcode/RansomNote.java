package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two stings ransomNote and magazine,
 * return true if ransomNote can be constructed from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 */
public class RansomNote {
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {

            Map<Character, Integer> magMap = new HashMap<>();

            for (int i = 0; i < magazine.length(); i++) {
                if (magMap.containsKey(magazine.charAt(i))) {
                    int value = magMap.get(magazine.charAt(i));
                    magMap.put(magazine.charAt(i), ++value);

                } else {
                    magMap.put(magazine.charAt(i), 1);
                }
            }

            for (int i = 0; i < ransomNote.length(); i++) {

                if (!magMap.containsKey(ransomNote.charAt(i))) {
                    return false;

                } else {
                    int value = magMap.get(ransomNote.charAt(i));
                    if (value < 1) return false;
                    magMap.put(ransomNote.charAt(i), --value);
                }
            }

            return true;
        }
    }

    /**
     * Improved solution
     */
    class Solution2 {
        public boolean canConstruct(String ransomNote, String magazine) {

            int[] arr = new int[26];

            for (int i = 0; i < magazine.length(); i++) {
                ++arr[magazine.charAt(i) - 'a'];
            }

            for (int i = 0; i < ransomNote.length(); i++) {
                if (--arr[ransomNote.charAt(i) - 'a'] < 0)
                    return false;
            }

            return true;
        }
    }
}
