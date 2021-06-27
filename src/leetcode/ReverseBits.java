package leetcode;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 *
 */
public class ReverseBits {
    public class Solution {
        public int reverseBits(int n) {
            int result = 0;

            for (int i = 0; i < 32; i++) {
                result <<= 1;
                result = result | (n & 1);
                n >>= 1;
            }

            return result;
        }
    }
}
