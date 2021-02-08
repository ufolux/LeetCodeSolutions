//
// Created by sines on 2021/2/8 .
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace Search_BFS_DFS_Backtrace {
    namespace L47_PermutationsII {
        using namespace std;

        class Solution : BaseSolution {
        private:
            vector<int> tmp;
            vector<int> visited;
            vector<vector<int>> ans;
            void dfs(vector<int>& nums, int start) {
                int len = nums.size();
                if (start == len) {
                    ans.emplace_back(tmp);
                } else {
                    for (int i = 0; i < len; ++i) {
                        if (visited[i] == 0) {
                            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] != 0) {
                                continue;
                            }
                            tmp.emplace_back(nums[i]);
                            visited[i] = 1;
                            dfs(nums, start + 1);
                            visited[i] = 0;
                            tmp.pop_back();
                        }
                    }
                }
            }
            vector<vector<int>> permuteUnique(vector<int>& nums) {
                sort(nums.begin(), nums.end());
                visited.resize(nums.size());
                dfs(nums, 0);
                return ans;
            }

        public:
            void run() override {
                vector<int> vec = {1,2,3};
                auto res = permuteUnique(vec);
                for (auto& v: res) {
                    OutputUtils::printVector(v);
                }
            }
        };
    }
}