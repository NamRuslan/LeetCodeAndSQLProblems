package leetcode;

/**
 * The Hamming distance between two integers is the number of positions
 * at which the corresponding bits are different.
 *
 * Given two integers x and y, return the Hamming distance between them.
 */
public class HammingDistance {
    class Solution {
        public int hammingDistance(int x, int y) {
            int mask = 1, count = 0;

            for (int i = 0; i < 32; i++) {
                if ((x & mask) != (y & mask)) {
                    count++;
                }
                mask = mask << 1;
            }
            return count;
        }
    }

    class Solution2{
        public int hammingDistance(int x, int y) {
            int xor = x ^ y, count = 0;

            for (int i = 0; i < 32; i++) {
                count += (xor >> i) & 1;
            }

            return count;
        }
    }
}
