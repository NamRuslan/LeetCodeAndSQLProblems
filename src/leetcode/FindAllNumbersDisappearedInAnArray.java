package leetcode;

import java.util.*;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [2]
 *
 * Follow up: Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 */
public class FindAllNumbersDisappearedInAnArray {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> list = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            int max = 0;

            for (int i : nums) {
                if (max < i) max = i;
                set.add(i);
            }

            for (int i = 1; i <= max || i <= nums.length; i++) {
                if (!set.contains(i)) {
                    list.add(i);
                }
            }

            return list;
        }
    }

    /**
     * Improved solution(Follow-up question: No extra space)
     */
    class Solution2 {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (nums[Math.abs(nums[i]) - 1] > 0) {
                    nums[Math.abs(nums[i]) - 1] *= -1;
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    list.add(i + 1);
                }
            }

            return list;
        }
    }
}
