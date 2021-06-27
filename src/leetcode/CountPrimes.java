package leetcode;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes {
    class Solution {
        public int countPrimes(int n) {

            if (n < 2) return 0;

            boolean[] mask = new boolean[n - 2];
            int count = 0;

            for (int i = 2; i <= Math.sqrt(n); i++) {

                if (mask[i - 2]) continue;

                int index = i;
                while (index + i < n) {
                    index += i;
                    mask[index - 2] = true;
                }
            }


            for (boolean b : mask) {
                if (!b) count++;
            }

            return count;
        }
    }
}
