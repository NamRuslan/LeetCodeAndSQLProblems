package leetcode;

/**
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has
 */
public class NumberOf1Bits {
    public class Solution {
        public int hammingWeight(int n) {
            int count = 0;
            int mask = 1;

            for (int i = 0; i < 32; i++) {
                if ((n & mask) != 0) {
                    count++;
                }

                mask <<= 1;
            }

            return count;
        }
    }
}
