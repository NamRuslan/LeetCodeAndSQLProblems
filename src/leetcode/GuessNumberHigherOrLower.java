package leetcode;

/**
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 *
 * You call a pre-defined API int guess(int num), which returns 3 possible results:
 *
 * -1: The number I picked is lower than your guess (i.e. pick < num).
 * 1: The number I picked is higher than your guess (i.e. pick > num).
 * 0: The number I picked is equal to your guess (i.e. pick == num).
 * Return the number that I picked.
 */
public class GuessNumberHigherOrLower {
    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            if (guess(n) == 0) return n;

            int left = 0, right = n + 1, mid;

            while (left < right) {
                mid = left + (right - left) / 2;
                if (guess(mid) == 0) {
                    return mid;
                }
                if (guess(mid) == -1) {
                    right = mid;
                } else {
                    left = mid;
                }

            }

            return -1;
        }
    }
    class GuessGame {
        int guess(int n) {
            return 0;
        }
    }
}
