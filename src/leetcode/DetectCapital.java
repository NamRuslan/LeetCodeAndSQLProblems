package leetcode;

/**
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Given a string word, return true if the usage of capitals in it is right.
 *
 *
 *
 * Example 1:
 *
 * Input: word = "USA"
 * Output: true
 * Example 2:
 *
 * Input: word = "FlaG"
 * Output: false
 */
public class DetectCapital {

/**
 * Iterative solution
 */
class Solution {
    public boolean detectCapitalUse(String word) {

        if (word.length() < 2) return true;

        if (Character.isLowerCase(word.charAt(1))) {
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < word.length(); i++) {
                if (Character.isLowerCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}

/**
 * String methods solution
 */
class Solution2 {
    public boolean detectCapitalUse(String word) {
        if (word.length() < 2) return true;
        if (Character.isUpperCase(word.charAt(1))) {
            return word.toUpperCase().equals(word);
        } else {
            return word.substring(1).toLowerCase().equals(word.substring(1));
        }
    }
}
}
