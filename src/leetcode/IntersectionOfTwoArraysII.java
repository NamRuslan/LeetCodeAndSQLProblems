package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays
 * and you may return the result in any order.
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 *
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 *
 * What if elements of nums2 are stored on disk, and the memory is limited
 * such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArraysII {

    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            ArrayList<Integer> ans = new ArrayList<>();

            for (int i : nums1) {
                for (int j = 0; j < nums2.length; j++) {
                    if (i == nums2[j]) {
                        ans.add(i);
                        nums2[j] = -1;
                        break;
                    }
                }
            }

            int[] res = new int[ans.size()];

            for (int i = 0; i < ans.size(); i++) {
                res[i] = ans.get(i);
            }

            return res;
        }
    }

    /**
     * Follow-up questions
     * #1:
     *  If arrays is sorted, it's coming easier to use two pointers
     * #2:
     *  As I use two pointers, there's no need to know which array is shorter.
     *  Algorithm will stop when the shortest array ends.
     * #3:
     *  As I understood #3 question, nums2 cannot be downloaded whole from disk, so I use
     *  nums1 as answer array. Due to constraints, there's no negative values in arrays,
     *  so I decided to mark all unique values as -1, and then gather all valid values from nums1.
     *  The thing is, I don't use whole nums2, but only 1 value from it at a time.
     */
    class Solution2 {
        public int[] intersect(int[] nums1, int[] nums2) {

            Arrays.sort(nums1);
            Arrays.sort(nums2);

            int n1 = 0, n2 = 0, count = 0;

            while (n1 < nums1.length && n2 < nums2.length) {

                if (nums1[n1] == nums2[n2]) {
                    n1++;
                    n2++;
                    count++;
                    continue;
                }

                if (nums1[n1] < nums2[n2]) {
                    nums1[n1] = -1;
                    n1++;
                } else {
                    n2++;
                }
            }

            int[] res = new int[count];
            int i = 0;

            while (count > 0) {
                if (nums1[i] != -1) {
                    res[--count] = nums1[i];
                }
                i++;
            }

            return res;
        }
    }
}
