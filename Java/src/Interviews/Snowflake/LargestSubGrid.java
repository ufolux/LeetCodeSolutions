package Interviews.Snowflake;

import java.util.List;

public class LargestSubGrid {
    // LargestSubGrid HackerRank
    int largestSubgrid(int[][] grid, int maxSum){
        int i, j;

        // N size of rows and M size of cols
        int n = grid.length;
        int m = grid[0].length;

        // To store the prefix sum of matrix
        int[][] sum = new int[n + 1][m + 1];

        // Create prefix sum
        for (i = 0; i <= n; i++) {

            // Traverse each rows
            for (j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    sum[i][j] = 0;
                    continue;
                }

                // Update the prefix sum
                // till index i x j
                sum[i][j] = grid[i - 1][j - 1]
                        + sum[i - 1][j] + sum[i][j - 1]
                        - sum[i - 1][j - 1];
            }
        }

        // To store the maximum size of
        // matrix with sum <= K
        int ans = 0;

        // Traverse the sum matrix
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {

                // Index out of bound
                if (i + ans - 1 > n || j + ans - 1 > m)
                    break;

                int mid, lo = ans;

                // Maximum possible size
                // of matrix
                int hi = Math.min(n - i + 1, m - j + 1);

                // Binary Search
                while (lo < hi) {

                    // Find middle index
                    mid = (hi + lo + 1) / 2;

                    // Check whether sum <= K
                    // or not
                    // If Yes check for other
                    // half of the search
                    if (sum[i + mid - 1][j + mid - 1]
                            + sum[i - 1][j - 1]
                            - sum[i + mid - 1][j - 1]
                            - sum[i - 1][j + mid - 1]
                            <= maxSum) {
                        lo = mid;
                    }

                    // Else check it in first
                    // half
                    else {
                        hi = mid - 1;
                    }
                }
                // Update the maximum size matrix
                ans = Math.max(ans, lo);
            }
        }

        // Print the final answer
        System.out.print(ans + "\n");
        return ans;
    }

    public static void main(String[] args) {
        LargestSubGrid largestSubGrid = new LargestSubGrid();
        int[][] grid = {{4,5},
                {6,7}};
        largestSubGrid.largestSubgrid(grid, 2);
    }
}
