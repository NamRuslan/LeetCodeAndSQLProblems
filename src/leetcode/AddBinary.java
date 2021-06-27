package leetcode;
import java.math.BigInteger;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 */
public class AddBinary {
    class Solution {
        public String addBinary(String a, String b) {
            BigInteger j = new BigInteger(b, 2);
            BigInteger i = new BigInteger(a, 2);
            i = i.add(j);
            return i.toString(2);
        }
    }
}
