package leetcode;

/**
 * Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
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
public class ExcelSheetColumnTitle {
    class Solution {
        public String convertToTitle(int columnNumber) {
            if (columnNumber < 0) {
                return "";
            }

            char key;
            int keyVal, nextColumn;
            StringBuilder s = new StringBuilder("");

            if (columnNumber <= 26) {
                s.append((char) (columnNumber + 64));
            } else {
                keyVal = columnNumber % 26;
                nextColumn = columnNumber / 26;
                if (keyVal == 0) {
                    s.append(convertToTitle(nextColumn - 1)).append((char) (64 + 26));
                } else {
                    s.append(convertToTitle(nextColumn)).append((char) (keyVal + 64));
                }
            }

            return String.valueOf(s);
        }
    }
}
