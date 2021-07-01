package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match,
 * such that there is a bijection between a letter in pattern and a non-empty word in s.
 *
 * Example 1:
 *
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 */
public class WordPattern {
    class Solution {
        public boolean wordPattern(String pattern, String s) {

            Map<Character, String> map = new HashMap<>();
            String[] words = s.split(" ");

            if (words.length != pattern.length()) return false;

            for (int i = 0; i < pattern.length(); i++) {

                char patternChar = pattern.charAt(i);

                if (!map.containsKey(patternChar) && !map.containsValue(words[i])) {
                    map.put(patternChar, words[i]);
                }

                if (!words[i].equals(map.get(patternChar))) {
                    return false;
                }
            }

            return true;
        }
    }
}
