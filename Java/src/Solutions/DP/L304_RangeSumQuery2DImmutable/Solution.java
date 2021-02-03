package Solutions.DP.L304_RangeSumQuery2DImmutable;

public class Solution {
    int[][] mtx;
    public void NumMatrix(int[][] matrix) {
        int r = matrix.length;
        if (r == 0) return;
        int c = matrix[0].length;
        if (c == 0) return;
        mtx = new int[r][c];
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (i != 0) {
                    mtx[i][j] += mtx[i - 1][j];
                }
                if (j != 0) {
                    mtx[i][j] += mtx[i][j - 1];
                }
                if (i != 0  && j != 0) {
                    mtx[i][j] -= mtx[i - 1][j - 1];
                }
                mtx[i][j] += matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(mtx == null) return 0;
        int result = 0;
        if(row1 > 0){
            result += mtx[row1 - 1][col2];
        }
        if (col1 > 0){
            result += mtx[row2][col1 - 1];
        }
        if(row1 > 0 && col1 > 0){
            result -= mtx[row1-1][col1-1];
        }
        return mtx[row2][col2] - result;
    }
}
