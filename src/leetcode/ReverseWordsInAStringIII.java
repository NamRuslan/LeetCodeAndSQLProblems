package leetcode;

import java.util.Arrays;

/**
 * Given a string s, reverse the order of characters in each word within
 * a sentence while still preserving whitespace and initial word order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * Example 2:
 *
 * Input: s = "God Ding"
 * Output: "doG gniD"
 */
public class ReverseWordsInAStringIII {

static class Solution {
    public String reverseWords(String s) {

        char[] chars = s.toCharArray();
        int left = 0, space = 0;

        while (space < s.length()) {
            while (space < s.length() && chars[space] != ' ') space++;
            reverseChars(chars, left, space - 1);
            left = ++space;
        }

        reverseChars(chars, left, space - 1);

        return new String(chars);
    }

    void reverseChars(char[] chars, int left, int right) {
        char buff;
        while (left < right) {
            buff = chars[left];
            chars[left++] = chars[right];
            chars[right--] = buff;
        }
    }
}

/**
 * Stream solution
 */
static class Solution2 {
    public String reverseWords(String s) {

         return Arrays.stream(s.split(" "))
                .map(StringBuilder::new)
                .reduce(new StringBuilder(), (sb1, sb2) -> sb1.append(sb2.reverse()).append(' '))
                .toString()
                .trim();

    }
}

}
