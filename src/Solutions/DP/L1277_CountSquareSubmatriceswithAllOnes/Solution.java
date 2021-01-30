package Solutions.DP.L1277_CountSquareSubmatriceswithAllOnes;

public class Solution {
    public int countSquares(int[][] matrix) {
        int r = matrix.length;
        if (r == 0) return 0;
        int c = matrix[0].length;
        int res = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (i != 0 && j != 0 && matrix[i][j] == 1) {
                    matrix[i][j] += Math.min(Math.min(matrix[i][j - 1], matrix[i - 1][j]), matrix[i - 1][j - 1]);
                }
                res += matrix[i][j];
            }
        }
        return res;
    }
}
