package leetcode;

/**
 * You are given row x col grid representing a map where grid[i][j] = 1
 * represents land and grid[i][j] = 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water, and there is exactly one island
 * (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 */
public class IslandPerimeter {
    class Solution {
        public int islandPerimeter(int[][] grid) {
            int per, sum = 0;

            for (int a = 0; a < grid.length; a++) {
                for (int b = 0; b < grid[a].length; b++) {
                    per = 4;
                    if (grid[a][b] != 0) {
                        if (a - 1 >= 0 && grid[a - 1][b] == 1) per--;
                        if (a + 1 < grid.length && grid[a + 1][b] == 1) per--;
                        if (b - 1 >= 0 && grid[a][b - 1] == 1) per--;
                        if (b + 1 < grid[a].length && grid[a][b + 1] == 1) per--;
                        sum += per;
                    }
                }
            }
            return sum;
        }
    }

    /**
     * Improved solution
     * Every connection between chunks reduces total perimeter by 2,
     * so we need to only check previous neighbours of single chunk
     * That way we reduce neighbour check in a half, compared to previous solution
     */
    class Solution2 {
        public int islandPerimeter(int[][] grid) {
            int sum = 0;

            for (int a = 0; a < grid.length; a++) {
                for (int b = 0; b < grid[a].length; b++) {
                    if (grid[a][b] == 1) {
                        sum += 4;
                        if (a - 1 >= 0 && grid[a - 1][b] == 1) sum -= 2;
                        if (b - 1 >= 0 && grid[a][b - 1] == 1) sum -= 2;
                    }
                }
            }

            return sum;
        }
    }
}
