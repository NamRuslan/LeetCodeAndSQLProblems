package leetcode;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 */
public class ReverseString {
    class Solution {
        public void reverseString(char[] s) {

            int left = 0, right = s.length - 1;
            char buff;
            while (left < right) {
                buff = s[left];
                s[left++] = s[right];
                s[right--] = buff;
            }
        }
    }
}
