package leetcode;

/**
 * Given a string columnTitle that represents the column title as appear in an Excel sheet,
 * return its corresponding column number.
 *
 * For example:
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 */
public class ExcelSheetColumnNumber {
    class Solution {
        public int titleToNumber(String columnTitle) {
            int result = 0;
            int i = columnTitle.length() - 1;

            while (i >= 0) {
                result += (columnTitle.charAt(i) - 64) * Math.pow(26, columnTitle.length() - i - 1);
                i--;
            }

            return result;
        }
    }
}
