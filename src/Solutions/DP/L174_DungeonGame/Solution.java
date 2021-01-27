package Solutions.DP.L174_DungeonGame;

public class Solution {
    private int dfs(int[][] dungeon, int[][] memo, int m, int n, int i, int j) {
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        int res = 0;
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

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}});
        System.out.println(res);
    }
}
