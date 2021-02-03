package Solutions.DFS.L200_NumberOfIslands;

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.numIslands(new char[][]{
            {
                '1', '1', '1', '1', '0'
            },
            {
                '1', '1', '0', '1', '0'
            },
            {
                '1', '1', '0', '0', '0'
            },
            {
                '0', '0', '0', '0', '0'
            },
        });
    }
}
