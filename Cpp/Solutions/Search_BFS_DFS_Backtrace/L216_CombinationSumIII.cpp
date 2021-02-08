//
// Created by sines on 2021/2/8 .
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace Search_BFS_DFS_Backtrace {
    namespace L216_CombinationSumIII {
        using namespace std;

        class Solution : BaseSolution {
        private:
            vector<vector<int>> ans;
            vector<int> comb;
            void dfs(int k, int n, int start) {
                if (n < 0) return;
                if (n == 0 && comb.size() == k) {
                    ans.push_back(comb);
                    return;
                }
                for (int i = start; i <= 9 && n - i >= 0; ++i) {
                    comb.push_back(i);
                    dfs(k, n - i, i + 1);
                    comb.pop_back();
                }
            }
            vector<vector<int>> combinationSum3(int k, int n) {
                dfs(k, n, 1);
                return ans;
            }
        public:
            void run() override {
                auto res = combinationSum3(3, 7);
                for (auto& v: res) {
                    OutputUtils::printVector(v);
                }
            }
        };
    }
}