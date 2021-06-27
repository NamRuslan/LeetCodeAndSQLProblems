package leetcode;

/**
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 */
public class ValidPalindrome {

    class Solution {
        public boolean isPalindrome(String s) {
            int left = 0;
            int right;

            s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            right = s.length() - 1;

            while (left <= right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }

            return true;
        }
    }

    /**
     * Improved solution (from 25ms to 2ms)
     */
    class Solution2 {
        public boolean isPalindrome(String s) {
            int left = 0;
            int right;
            char leftC, rightC;

            right = s.length() - 1;
            s = s.toLowerCase();

            while(left <= right) {
                leftC = s.charAt(left);
                rightC = s.charAt(right);

                if (!(leftC >= 'A' && leftC <= 'Z' || leftC >= 'a' && leftC <= 'z' || leftC >= '0' && leftC <='9')) {
                    left++;
                    continue;
                }

                if (!(rightC >= 'A' && rightC <= 'Z' || rightC >= 'a' && rightC <= 'z' || rightC >= '0' && rightC <='9')) {
                    right--;
                    continue;
                }

                if (leftC != rightC) {
                    return false;
                }
                left++;
                right--;
            }

            return true;
        }
    }
}
