//
// Created by sines on 2021/2/8 .
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace Search_BFS_DFS_Backtrace {
    namespace L40_CombinationSumII {
        using namespace std;

        class Solution : BaseSolution {
        private:
            void dfs(vector<int>& candidates, int start, int target, vector<int>& tmp, vector<vector<int>>& ans) {
                if (target < 0) return;
                if (target == 0) {
                    ans.push_back(tmp);
                    return;
                }
                int len = candidates.size();
                for (int i = start; i < len; ++i) {
                    int n = candidates[i];
                    tmp.push_back(n);
                    dfs(candidates, i + 1, target - n, tmp, ans);
                    tmp.pop_back();
                }
            }

            vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
                vector<int> tmp;
                vector<vector<int>> ans;
                dfs(candidates, 0, target, tmp, ans);
                return ans;
            }
        public:
            void run() override {
                vector<int> vec = {10,1,2,7,6,1,5};
                auto ans = combinationSum2(vec, 8);
                for (auto v: ans) {
                    OutputUtils::printVector(v);
                }
            }
        };
    }
}