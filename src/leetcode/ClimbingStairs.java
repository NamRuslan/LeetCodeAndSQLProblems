package leetcode;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    class Solution {
        public int climbStairs(int n) {
            if (n == 1) return 1;
            int twoBefore = 1, oneBefore = 2, current = 2;

            for (int i = 3; i <= n; i++) {
                current = twoBefore + oneBefore;
                twoBefore = oneBefore;
                oneBefore = current;
            }

            return current;
        }
    }
}
