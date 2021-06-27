package leetcode;

/**
 * Given a string s consists of some words separated by spaces, return the length of the last word in the string.
 * If the last word does not exist, return 0.
 *
 * A word is a maximal substring consisting of non-space characters only.
 */
public class LengthOfLastWord {
    class Solution {
        public int lengthOfLastWord(String s) {
            String[] sArr = s.split(" ");
            if (sArr.length == 0) return 0;
            return sArr[sArr.length - 1].length();
        }
    }
}
