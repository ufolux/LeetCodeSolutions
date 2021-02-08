//
// Created by sines on 2021/2/8 .
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace Search_BFS_DFS_Backtrace {
    namespace L78_Subsets {
        using namespace std;

        class Solution : BaseSolution {
        private:
            vector<int> paths;
            vector<vector<int>> ans = {};
            void dfs(vector<int>& nums, int start) {
                int len = nums.size();
                ans.push_back(paths);
                for (int i = start; i < len; ++i) {
                    int n = nums[i];
                    paths.push_back(n);
                    dfs(nums, i + 1);
                    paths.pop_back();
                }
            }
            vector<vector<int>> subsets(vector<int>& nums) {
                dfs(nums, 0);
                return ans;
            }
        public:
            void run() override {
                vector<int> vec = {1,2,3,4,5,6};
                auto ans = subsets(vec, 0);
                for (auto& v: ans) {
                    OutputUtils::printVector(v);
                }

            }
        };
    }
}