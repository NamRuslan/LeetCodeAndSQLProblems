package leetcode;

import java.util.*;

/**
 * Given integer array nums, return the third maximum number in this array.
 * If the third maximum does not exist, return the maximum number.
 *
 * Example 1:
 *
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation: The third maximum is 1.
 * Example 2:
 *
 * Input: nums = [1,2]
 * Output: 2
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 *
 * Input: nums = [2,2,3,1]
 * Output: 1
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class ThirdMaximumNumber {
    static class Solution {
        public static int thirdMax(int[] nums) {

            Integer max = null;
            Integer mid = null;
            Integer min = null;

            for (Integer i : nums) {
                if (i.equals(max) || i.equals(mid) || i.equals(min)) {
                    continue;
                }

                if (max == null || i > max) {
                    min = mid;
                    mid = max;
                    max = i;

                } else if (mid == null || i > mid) {
                    min = mid;
                    mid = i;

                } else if (min == null || i > min) {
                    min = i;
                }
            }

            if (min != null) return min;
            else return max;
        }
    }
}
