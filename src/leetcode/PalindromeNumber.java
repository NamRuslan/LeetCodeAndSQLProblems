package leetcode;

/**
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
 */
public class PalindromeNumber {
    class Solution {
        public boolean isPalindrome(int x) {

            StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));
            return String.valueOf(x).equals(String.valueOf(stringBuilder.reverse()));
        }
    }
}
