package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order.
 */
public class IntersectionOfTwoArrays {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {

            Set<Integer> set = new HashSet<>();
            Set<Integer> res = new HashSet<>();

            for (int i : nums1) {
                set.add(i);
            }
            for (int i : nums2) {
                if (set.contains(i)) {
                    res.add(i);
                }
            }

            int[] ans = new int[res.size()];
            int index = 0;
            for (int i : res) {
                ans[index++] = i;
            }

            return ans;
        }
    }
}
