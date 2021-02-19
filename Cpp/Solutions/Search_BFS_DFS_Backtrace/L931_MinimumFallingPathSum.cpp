//
// Created by qingshuihe on 2021/2/19 .
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace Search_BFS_DFS_Backtrace {
    namespace L931_MinimumFallingPathSum {
        using namespace std;

        class Solution : BaseSolution {
        private:
            int dfs(vector<vector<int>>& A, vector<vector<int>>& memo, int row, int col, int i, int j) {
                if (memo[i][j] != INT_MIN) return memo[i][j];
                if (i == row - 1) {
                    memo[i][j] = A[i][j];
                } else if (j == col - 1) {
                    memo[i][j] = A[i][j] + min(dfs(A, memo, row, col, i + 1, j), dfs(A, memo, row, col, i + 1, j - 1));
                } else if (j == 0) {
                    memo[i][j] = A[i][j] + min(dfs(A, memo, row, col, i + 1, j + 1), dfs(A, memo, row, col, i + 1, j));
                } else {
                    memo[i][j] = A[i][j] + min(min(dfs(A, memo, row, col, i + 1, j), dfs(A, memo, row, col, i + 1, j - 1)), dfs(A, memo, row, col, i + 1, j + 1));
                }
                return memo[i][j];
            }
            int minFallingPathSum(vector<vector<int>>& matrix) {
                int row = matrix.size();
                int col = matrix[0].size();
                int res = 1000;
                vector<vector<int>> memo(row, vector<int>(col, INT_MIN));
                for (int i = 0; i < col; ++i) {
                    for (int j = 0; j < row; ++j) {
                        res = min(res, dfs(matrix, memo, row, col, 0, i));
                    }
                }
                return res;
            }
        public:
            void run() override {
                vector<vector<int>> matrix = {{2,1,3},{6,5,4},{7,8,9}};
                cout << minFallingPathSum(matrix) << endl;
            }
        };
    }
}