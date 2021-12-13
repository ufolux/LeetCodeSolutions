package Solutions.DFS.L200_NumberOfIslands;

class Solution {
    void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) return;
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }

    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
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
