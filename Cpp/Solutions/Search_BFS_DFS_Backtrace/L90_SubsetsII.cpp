//
// Created by sines on 2021/2/8 .
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace Search_BFS_DFS_Backtrace {
    namespace L90_SubsetsII {
        using namespace std;

        class Solution : BaseSolution {
        private:
            vector<int> path;
            vector<vector<int>> ans;
            void dfs(vector<int>& nums, int start) {
                int len = nums.size();
                ans.push_back(path);
                for (int i = start; i < len; ++i) {
                    int n = nums[i];
                    if (i > start && nums[i] == nums[i - 1]) {
                        continue;
                    }
                    path.push_back(n);
                    dfs(nums, i + 1);
                    path.pop_back();
                }
            }

            vector<vector<int>> subsetsWithDup(vector<int>& nums) {
                sort(nums.begin(), nums.end());
                dfs(nums, 0);
                return ans;
            }
        public:
            void run() override {
                vector<int> vec = {1,2,2};
                auto res = subsetsWithDup(vec);
                OutputUtils::printMatrix(res);
            }
        };
    }
}