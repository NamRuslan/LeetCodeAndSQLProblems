package leetcode;

public class RomanToInteger {
    class Solution {
        public int romanToInt(String s) {
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)){
                    case 'M':
                        if (i != 0 && s.charAt(i - 1) == 'C') break;
                        res += 1000;
                        break;
                    case 'D':
                        if (i != 0 && s.charAt(i - 1) == 'C') break;
                        res += 500;
                        break;
                    case 'C':
                        if (i != 0 && s.charAt(i - 1) == 'X') break;
                        if (i != s.length() - 1 && s.charAt(i + 1) == 'D') {
                            res += 400;
                            break;
                        }
                        if (i != s.length() - 1 && s.charAt(i + 1) == 'M') {
                            res += 900;
                            break;
                        } else res += 100;
                        break;
                    case 'L':
                        if (i != 0 && s.charAt(i - 1) == 'X') break;
                        res += 50;
                        break;
                    case 'X':
                        if (i != 0 && s.charAt(i - 1) == 'I') break;
                        if (i != s.length() - 1 && s.charAt(i + 1) == 'L') {
                            res += 40;
                            break;
                        }
                        if (i != s.length() - 1 && s.charAt(i + 1) == 'C') {
                            res += 90;
                            break;
                        } else res += 10;
                        break;
                    case 'V':
                        if (i != 0 && s.charAt(i - 1) == 'I') break;
                        res += 5;
                        break;
                    case 'I':
                        if (i != s.length() - 1 && s.charAt(i + 1) == 'V') {
                            res += 4;
                            break;
                        }
                        if (i != s.length() - 1 && s.charAt(i + 1) == 'X') {
                            res += 9;
                            break;
                        } else res += 1;
                        break;
                }
                System.out.println("Step " + (i + 1) + ": " + res);
            }
            return res;
        }
    }

    /**
     * Improved solution
     */
    class Solution2 {
        public int romanToInt(String s) {

            int res = convert(s.charAt(s.length() - 1));
            for (int i = s.length() - 2; i >= 0; i--) {
                if (convert(s.charAt(i)) < convert(s.charAt(i + 1))) {
                    res -= convert(s.charAt(i));
                } else {
                    res += convert(s.charAt(i));
                }
            }

            return res;
        }

        public int convert(char c) {

            switch (c) {
                case 'I' : return 1;
                case 'V' : return 5;
                case 'X' : return 10;
                case 'L' : return 50;
                case 'C' : return 100;
                case 'D' : return 500;
                case 'M' : return 1000;
            }

            return 0;
        }
    }
}
