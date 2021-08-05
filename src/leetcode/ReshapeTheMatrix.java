package leetcode;

/**
 * In MATLAB, there is a handy function called reshape which can reshape an m x n matrix
 * into a new one with a different size r x c keeping its original data.
 *
 * You are given an m x n matrix mat and two integers r and c representing the number of
 * rows and the number of columns of the wanted reshaped matrix.
 *
 * The reshaped matrix should be filled with all the elements of the original matrix in the
 * same row-traversing order as they were.
 *
 * If the reshape operation with given parameters is possible and legal, output the new reshaped matrix;
 * Otherwise, output the original matrix.
 */
public class ReshapeTheMatrix {

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        if (r * c != mat.length * mat[0].length || r == mat.length && c == mat[0].length) {
            return mat;
        }

        int[][] res = new int[r][c];
        int rInd = 0, cInd = 0;

        for (int a = 0; a < mat.length; a++) {
            for (int b = 0; b < mat[0].length; b++) {

                if (cInd == c) {
                    cInd = 0;
                    rInd++;
                }
                res[rInd][cInd++] = mat[a][b];

            }
        }

        return res;
    }
}

}
