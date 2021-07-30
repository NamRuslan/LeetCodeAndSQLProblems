package leetcode;

/**
 *Given a string s and an integer k, reverse the first k characters for every
 * 2k characters counting from the start of the string.
 *
 * If there are fewer than k characters left, reverse all of them.
 * If there are less than 2k but greater than or equal to k characters,
 * then reverse the first k characters and left the other as original.
 *
 * Example 1:
 *
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 *
 * Example 2:
 *
 * Input: s = "abcd", k = 2
 * Output: "bacd"
 */
public class ReverseStringII {

/**
 * StringBuilder solution
 */
class Solution {
    public String reverseStr(String s, int k) {

        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int oddEven = 0;

        for (int i = 0; i < s.length(); i += k) {
            temp.replace(0, temp.length(), s.substring(i, Math.min(i + k, s.length())));

            if (oddEven % 2 == 0) {
                ans.append(temp.reverse());
            } else {
                ans.append(temp);
            }

            oddEven++;
        }

        return ans.toString();
    }
}

/**
 * Iterable CharArray solution
 */
class Solution2 {
    public String reverseStr(String s, int k) {

        char[] chars = s.toCharArray();
        char temp;
        int left, right;

        for (int i = 0; i < s.length(); i += k * 2) {
            left = i;
            right = Math.min(i + k, s.length());
            while (left < right) {
                temp = chars[left];
                chars[left++] = chars[--right];
                chars[right] = temp;
            }
        }

        return new String(chars);
    }
}
}