package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a sorted unique integer array nums.
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 * That is, each element of nums is covered by exactly one of the ranges, and there is no integer
 * x such that x is in one of the ranges but not in nums.
 *
 * Each range [a,b] in the list should be output as:
 *
 * "a->b" if a != b
 * "a" if a == b
 */
public class SummaryRanges {
    class Solution {
        public List<String> summaryRanges(int[] nums) {

            List<String> list = new ArrayList<>();
            StringBuilder s = new StringBuilder();
            boolean hasRange = false;

            for (int i = 0; i < nums.length; i++) {

                if (!hasRange) {
                    s.append(nums[i]);
                }

                if (i + 1 == nums.length || i + 1 < nums.length && nums[i + 1] - nums[i] != 1) {

                    if (hasRange) {
                        s.append("->");
                        s.append(nums[i]);
                    }

                    list.add(String.valueOf(s));
                    hasRange = false;
                    s.delete(0, s.length());
                    continue;
                }

                hasRange = true;
            }

            return list;
        }
    }
}
