package leetcode;

/**
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 */
public class SearchInsertPosition {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int count = 0;
            for (int i : nums) {
                if (target <= i) break;
                count++;

            }
            return count;
        }
    }

    /**
     * Improved solution
     */
    class Solution2 {
        public int searchInsert(int[] nums, int target) {

            int left = 0, right = nums.length - 1, mid;

            while (left <= right) {
                mid = left + (right - left) / 2;
                if (target == nums[mid]) return mid;

                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return left;
        }
    }
}
