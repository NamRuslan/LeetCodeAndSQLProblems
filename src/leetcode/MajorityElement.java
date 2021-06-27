package leetcode;

import java.util.Arrays;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 */
public class MajorityElement {
    class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);

            int result = nums[0];
            int count = 0;

            for (int i : nums) {
                if (result == i) {
                    count++;
                } else {
                    result = i;
                    count = 0;
                }

                if (count >= (nums.length + 1) / 2) {
                    break;
                }
            }
            return result;
        }
    }

    /**
     * Improved solution, based on Boyer-Moore voting algorithm
     */
    class Solution2 {
        public int majorityElement(int[] nums) {
            int current = nums[0];
            int count = 0;

            for (int i : nums) {
                if (count == 0) {
                    current = i;
                    count++;
                } else {

                    if (current == i) {
                        count++;
                    } else {
                        count--;
                    }
                }
            }

            return current;
        }
    }
}
