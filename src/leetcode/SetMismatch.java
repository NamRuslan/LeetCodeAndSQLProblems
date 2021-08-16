package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * You have a set of integers s, which originally contains all the numbers from 1 to n.
 * Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
 * \which results in repetition of one number and loss of another number.
 *
 * You are given an integer array nums representing the data status of this set after the error.
 *
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 *
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [1,2]
 */
public class SetMismatch {
class Solution {
    public int[] findErrorNums(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int[] res = new int[2];
        int numsSum = 0;

        for (int i : nums) {
            numsSum += i;
            if (set.contains(i)) {
                res[0] = i;
            }
            set.add(i);
        }

        res[1] = ((1 + nums.length) * nums.length / 2) - (numsSum - res[0]);

        return res;
    }
}

/**
 * Improved solution (11ms -> 1 ms)
 * Though time complexity is still O(n)(find element in Set is O(1))
 * the number of operations is less than in previous solution.
 */
class Solution2 {
    public int[] findErrorNums(int[] nums) {

        int[] res = new int[2];
        int[] temp = new int[nums.length];

        for (int i : nums) {
            if (temp[i - 1] != 0) {
                res[0] = temp[i - 1];
            }
            temp[i - 1] = i;
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                res[1] = i + 1;
                break;
            }
        }

        return res;
    }
}

}
