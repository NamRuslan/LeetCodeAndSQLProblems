package leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String res = "";
            boolean isCommon = true;
            if (strs.length != 0) {
                for (int i = 0; i < strs[0].length(); i++) {
                    for (String s : strs) {
                        if (s.length() != 0) {
                            if (s.length() < i + 1 || !strs[0].substring(0, i + 1).equals(s.substring(0, i + 1))) {
                                isCommon = false;
                                break;
                            }
                        } else {
                            isCommon = false;
                            break;
                        }
                    }
                    if (isCommon) res = strs[0].substring(0, i + 1);
                    else break;
                }
            }
            return res;
        }
    }

    /**
     * Improved solution a month after
     */
    class Solution2 {
        public String longestCommonPrefix(String[] strs) {

            String patt = strs[0];
            boolean found = false;

            while (!found) {
                for (String s : strs) {
                    if (s.indexOf(patt) != 0) {
                        patt = patt.substring(0, patt.length() - 1);
                        found = false;
                        break;
                    }
                    found = true;
                }
            }

            return patt;
        }
    }
}
