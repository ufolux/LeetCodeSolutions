//
// Created by qingshuihe on 2021/2/19 .
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace DP {
    namespace L931_MinimumFallingPathSum {
        using namespace std;

        class Solution : BaseSolution {
        private:
            static int minFallingPathSum(vector<vector<int>>& matrix) {
                int row = matrix.size();
                int col = matrix[0].size();

                vector<vector<int>> dp(row, vector<int>(col, 0));
                for (int i = 0; i < col; i++) {
                    dp[0][i] = matrix[0][i];
                }
                for (int i = 1; i < row; ++i) {
                    int res;
                    for (int j = 0; j < col; ++j) {
                        if (j == 0) {
                            res = matrix[i][j] + min(dp[i - 1][j], dp[i - 1][j + 1]);
                        } else if (j == col - 1) {
                            res = matrix[i][j] + min(dp[i - 1][j], dp[i - 1][j - 1]);
                        } else {
                            res = matrix[i][j] + min(min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i - 1][j + 1]);
                        }
                        dp[i][j] = res;
                    }
                }
                int res = INT_MAX;
                for (int i = 0; i < col; ++i) {
                    res = min(res, dp[row - 1][i]);
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