//
// Created by sines on 2021/2/7 .
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace Search_BFS_DFS_Backtrace {
    namespace L39_CombinationSum {
        using namespace std;

        class Solution : BaseSolution {
        private:
            void dfs(vector<int>& candidates, int start, int target, vector<int>& tmp, vector<vector<int>>& ans) {
                if (target < 0) return;
                if (target == 0) {
                    ans.push_back(tmp);
                }
                int len = candidates.size();
                for (int i = start; i < len; ++i) {
                    int n = candidates[i];
                    tmp.push_back(n);
                    dfs(candidates, i, target - n, tmp, ans);
                    tmp.pop_back();
                }
            }

            vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
                if (candidates.empty()) return {};
                sort(candidates.begin(), candidates.end());
                vector<vector<int>> ans;
                vector<int> tmp;
                dfs(candidates, 0, target, tmp, ans);
                return ans;
            }
        public:
            void run() override {
                vector<int> vec = {2,3,6,7};
                auto ans = combinationSum(vec, 7);
                OutputUtils::printMatrix(ans);
            }
        };
    }
}