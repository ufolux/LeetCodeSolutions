//
// Created by qingshuihe on 2021/2/19 .
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace DP {
    namespace L174_DungeonGame {
        using namespace std;

        class Solution : BaseSolution {
        private:
            int dfs(vector<vector<int>>& dungeon, vector<vector<int>>& memo, int m, int n, int i, int j) {
                int res = 0;
                if (memo[i][j] > 0)
                    return memo[i][j];
                if (i == m - 1 && j == n - 1) {
                    res = max(1 - dungeon[i][j], 1);
                } else if (i == m - 1) {
                    res = max(dfs(dungeon, memo, m, n, i, j + 1) - dungeon[i][j], 1);
                } else if (j == n - 1) {
                    res = max(dfs(dungeon, memo, m, n, i + 1, j) - dungeon[i][j], 1);
                } else {
                    res = max(min(dfs(dungeon, memo, m, n, i, j + 1), dfs(dungeon, memo, m, n, i + 1, j)) - dungeon[i][j], 1);
                }
                memo[i][j] = res;
                return res;
            }
            int calculateMinimumHP(vector<vector<int>>& dungeon) {
                int m = dungeon.size();
                int n = dungeon[0].size();
                vector<vector<int>> memo(m, vector<int>(n, 0));
                return dfs(dungeon, memo, m, n, 0, 0);
            }
        public:
            void run() override {
                vector<vector<int>> dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
                cout << calculateMinimumHP(dungeon) << endl;
            }
        };
    }
}