package leetcode;

/**
 * You are given a string s, return the number of segments in the string.
 *
 * A segment is defined to be a contiguous sequence of non-space characters.
 */
public class NumberOfSegmentsInAString {
    class Solution {
        public int countSegments(String s) {

            int ans = 0;

            String[] res = s.split(" ");

            for (String string : res) {
                if (string.length() > 0) {
                    ans++;
                }
            }

            return ans;
        }
    }
}
