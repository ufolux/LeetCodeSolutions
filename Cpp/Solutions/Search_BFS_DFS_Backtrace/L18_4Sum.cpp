//
// Created by sines on 2021/2/9 .
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace Search_BFS_DFS_Backtrace {
    namespace L18_4Sum {
        using namespace std;

        class Solution : BaseSolution {
        private:
            vector<vector<int>> ans;
            vector<int> tmp;
            void dfs(vector<int>& nums, int target, int start) {
                int len = static_cast<int>(nums.size());
                if (target == 0 && tmp.size() == 4) {
                    ans.emplace_back(tmp);
                    return;
                }
                for (int i = start; i < len; ++i) {
                    int n = nums[i];
                    if (4 - tmp.size() > len - i + 1) return;
                    if (int(4 - tmp.size()) * nums[i] > target) return;
                    if (int(4 - tmp.size()) * nums.back() < target) return;
                    if (i > start && n == nums[i - 1]) continue;
                    tmp.emplace_back(n);
                    dfs(nums, target - n, i + 1);
                    tmp.pop_back();
                }
            }

            vector<vector<int>> fourSum(vector<int>& nums, int target) {
                sort(nums.begin(), nums.end());
                dfs(nums, target, 0);
                return ans;
            }
        public:
            void run() override {
                vector<int> vec = {1,0,-1,0,-2,2};
                auto res = fourSum(vec, 0);
                OutputUtils::printMatrix(res);
            }
        };
    }
}