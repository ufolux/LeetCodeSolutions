package Solutions.Array.L994_RottingOranges;

import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        List<int[]> arr = new ArrayList();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) arr.add(new int[]{i, j});
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int min = 0;

        while (arr.size() != 0) {
            List<int[]> newArr = new ArrayList();
            for (int[] rotOran: arr) {
                int x0 = rotOran[0];
                int y0 = rotOran[1];

                for (int k = 0; k < 4; k++) {
                    int x = x0 + dx[k];
                    int y = y0 + dy[k];
                    if (0 <= x && grid[0].length > x && 0 <= y && grid[1].length > y) {
                        grid[x][y] = grid[x][y] == 1 ? 2 : 0;
                        if (grid[x][y] == 2) newArr.add(new int[]{x, y});
                    }
                }
            }

            if (newArr.size() == 0)
                break;

            arr = newArr;
            min++;
        }

        for (int[] i: grid)
            for (int j: i)
                if (j == 1)
                    return -1;

        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}});
    }
}
