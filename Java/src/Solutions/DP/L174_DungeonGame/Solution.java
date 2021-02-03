package Solutions.DP.L174_DungeonGame;

public class Solution {
    private int dfs(int[][] dungeon, int[][] memo, int m, int n, int i, int j) {
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        int res;
        if (i == m - 1 && j == n - 1) {
            res = Math.max(1 - dungeon[i][j], 1);
        } else if (i == m - 1) {
            res = Math.max(dfs(dungeon, memo, m, n, i, j + 1) - dungeon[i][j], 1);
        } else if (j == n - 1) {
            res = Math.max(dfs(dungeon, memo, m, n, i + 1, j) - dungeon[i][j], 1);
        } else {
            res = Math.max(Math.min(dfs(dungeon, memo, m, n, i, j + 1),
                    dfs(dungeon, memo, m, n, i + 1, j)) - dungeon[i][j], 1);
        }
        memo[i][j] = res;
        return res;
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] memo = new int[m][n];
        return dfs(dungeon, memo, m, n, 0, 0);
    }

    public int calculateMinimumHP_DP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = rows - 1; i >= 0; --i) {
            for (int j = cols - 1; j >= 0; --j) {
                if (i == rows - 1 && j == cols - 1) {
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else if (i == rows - 1) {
                    dp[i][j] = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                } else if (j == cols - 1) {
                    dp[i][j] = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                } else {
                    dp[i][j] = Math.max(Math.min(dp[i + 1][j] - dungeon[i][j], dp[i][j + 1] - dungeon[i][j]), 1);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res1 = s.calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}});
        int res2 = s.calculateMinimumHP_DP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}});
        System.out.println(res1);
        System.out.println(res2);
    }
}
