package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums and an integer k, return true if there are two distinct
 * indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k
 */
public class ContainsDuplicateII {
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    for (int j = i - 1; j >= i - k; j--) {
                        if (nums[j] == nums[i]) {
                            return true;
                        }
                    }

                } else {
                    set.add(nums[i]);
                }
            }

            return false;
        }
    }
}
