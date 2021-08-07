package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * We define a harmonious array as an array where the difference between its maximum value
 * and its minimum value is exactly 1.
 *
 * Given an integer array nums, return the length of its longest harmonious subsequence among
 * all its possible subsequences.
 *
 * A subsequence of array is a sequence that can be derived from the array by deleting some
 * or no elements without changing the order of the remaining elements.
 *
 * Example 1:
 *
 * Input: nums = [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: 2
 *
 * Example 3:
 *
 * Input: nums = [1,1,1,1]
 * Output: 0
 */
public class LongestHarmoniousSubsequence {

/**
 * This solution has 2 loops, but instead less operations, thus better time performance
 */
class Solution {
    public int findLHS(int[] nums) {

        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : map.keySet()) {
            if (map.containsKey(i + 1)) {
                count = Math.max(count, map.get(i) + map.get(i + 1));
            }
        }

        return count;
    }
}

class Solution2 {
public int findLHS(int[] nums) {
    int count = 0;

    Map<Integer, Integer> map = new HashMap<>();

    for (int i : nums) {
        map.put(i, map.getOrDefault(i, 0) + 1);
        if (map.containsKey(i - 1)) {
            count = Math.max(count, map.get(i) + map.get(i - 1));
        }

        if (map.containsKey(i + 1)) {
            count = Math.max(count, map.get(i) + map.get(i + 1));
        }
    }

    return count;
}
}

}