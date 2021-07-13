package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return a string array answer (1-indexed) where:
 *
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i if non of the above conditions are true.
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["1","2","Fizz"]
 * Example 2:
 *
 * Input: n = 5
 * Output: ["1","2","Fizz","4","Buzz"]
 */
public class FizzBuzz {
    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> result = new ArrayList<>();

            for (int i = 1; i <= n; i++) {

                StringBuilder s = new StringBuilder();

                if (i % 3 == 0) {
                    s.append("Fizz");
                }
                if (i % 5 == 0) {
                    s.append("Buzz");
                }
                if (i % 3 != 0 && i % 5 != 0) {
                    s.append(i);
                }

                result.add(s.toString());
            }

            return result;
        }
    }
}
