package leetcode;

/**
 * Given an integer array nums,
 * move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeroes {
    class Solution {
        public void moveZeroes(int[] nums) {

            int buff, j;
            boolean wasZero = false;

            for (int i = 0; i < nums.length; i++) {

                if (nums[i] == 0) {
                    wasZero = true;
                    continue;
                }

                if (wasZero && nums[i] != 0) {
                    j = i;
                    while (j > 0 && nums[j - 1] == 0) {
                        buff = nums[j];
                        nums[j] = nums[j - 1];
                        nums[j - 1] = buff;
                        j--;
                    }
                    wasZero = false;
                    i--;
                }
            }
        }
    }

    /**
     * Improved solution (7ms -> 0ms)
     */
    class Solution2 {
        public void moveZeroes(int[] nums) {

            int index = -1;

            for (int i = 0; i < nums.length; i++) {

                if (nums[i] != 0) {
                    nums[++index] = nums[i];
                    if (index != i) nums[i] = 0;
                }
            }
        }
    }
}
