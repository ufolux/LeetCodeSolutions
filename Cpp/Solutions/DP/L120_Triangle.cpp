//
// Created by qingshuihe on 2021/2/19 .
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace DP {
    namespace L120_Triangle {
        using namespace std;

        class Solution : BaseSolution {
        private:
            static int minimumTotal(vector<vector<int>>& triangle) {
                size_t len = triangle.size();
                int dp[len + 1];
                memset(dp, 0, sizeof(dp));
                for (size_t i = len - 1; i >= 0; --i) {
                    auto row = triangle[i];
                    for (int j = 0; j < row.size(); ++j) {
                        dp[j] = min(dp[j], dp[j + 1]) + row[j];
                    }
                }
                return dp[0];
            }
        public:
            void run() override {
                vector<vector<int>> triangle = {{2},{3,4},{6,5,7},{4,1,8,3}};
                minimumTotal(triangle);
            }
        };
    }
}