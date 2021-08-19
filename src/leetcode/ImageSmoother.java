package leetcode;

/**
 * An image smoother is a filter of the size 3 x 3 that can be applied to each cell of
 * an image by rounding down the average of the cell and the eight surrounding cells
 * (i.e., the average of the nine cells in the blue smoother).
 * If one or more of the surrounding cells of a cell is not present, we do not consider
 * it in the average (i.e., the average of the four cells in the red smoother).
 *
 * Given an m x n integer matrix img representing the grayscale of an image,
 * return the image after applying the smoother on each cell of it.
 *
 * Example 1:
 *
 * Input: img = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[0,0,0],[0,0,0],[0,0,0]]
 * Explanation:
 * For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 *
 * Example 2:
 *
 * Input: img = [[100,200,100],[200,50,200],[100,200,100]]
 * Output: [[137,141,137],[141,138,141],[137,141,137]]
 * Explanation:
 * For the points (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
 * For the points (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
 * For the point (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
 */
public class ImageSmoother {

/**
 * First we need to describe a method to get smoothed value of single element.
 * To keep it simple, we just limit both loops from 'element index' - 1 to 'element index' + 1.
 * And if it's out of bounds, just skip.
 * Thus, we have sum and count of elements, from which we return average.
 *
 * Second we create new array and fill each cell with smoothed value.
 */
class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] res = new int[img.length][img[0].length];

        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                res[i][j] = getSmoothedValue(img, i, j);
            }
        }

        return res;
    }

    int getSmoothedValue(int[][] img, int x, int y) {
        int sum = 0, count = 0;

        for (int i = x - 1; i <= x + 1; i++) {
            if (i < 0 || i >= img.length) continue;

            for (int j = y - 1; j <= y + 1; j++) {
                if (j < 0 || j >= img[0].length) continue;
                sum += img[i][j];
                count++;
            }
        }

        return sum / count;
    }
}


}
