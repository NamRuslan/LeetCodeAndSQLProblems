package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "hello"
 * Output: "holle"
 *
 *
 * Example 2:
 *
 * Input: s = "leetcode"
 * Output: "leotcede"
 */
public class ReverseVowelsOfAString {

    class Solution {
        public String reverseVowels(String s) {

            int left = 0, right = s.length() - 1;
            Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
            char[] result = s.toCharArray();

            while (left < right) {
                while (!vowels.contains(result[left]) && left < right) {
                    left++;
                }
                while (!vowels.contains(result[right]) && left < right) {
                    right--;
                }

                char buff = result[left];
                result[left++] = result[right];
                result[right--] = buff;
            }
            return new String(result);
        }
    }
}
