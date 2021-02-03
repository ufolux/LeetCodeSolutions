package Solutions.DP.L221_MaximalSquare;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r][c];
        int max = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (matrix[i][j] == '1') {
                    if (j == 0 && i == 0) {
                        dp[i][j] = 1;
                    } else if (i != 0 && j != 0) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
