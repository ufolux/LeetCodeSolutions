//
// Created by sines on 2021/2/8 .
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace Search_BFS_DFS_Backtrace {
    namespace L46_Permutations {
        using namespace std;

        class Solution : BaseSolution {
        private:
            vector<int> tmp;
            vector<vector<int>> ans;
            unordered_set<int> st;
            void dfs(vector<int>& nums) {
                int len = nums.size();
                if (tmp.size() == len) {
                    ans.emplace_back(tmp);
                    return;
                }
                for (int i = 0; i < len; i++) {
                    int n = nums[i];
                    if (st.count(n))
                        continue;
                    tmp.emplace_back(n);
                    st.insert(n);
                    dfs(nums);
                    st.erase(tmp.back());
                    tmp.pop_back();
                }
            }
            vector<vector<int>> permute(vector<int>& nums) {
                sort(nums.begin(), nums.end());
                dfs(nums);
                return ans;
            }
        public:
            void run() override {
                vector<int> vec = {1,2,3};
                auto res = permute(vec);
                OutputUtils::printMatrix(res);
            }
        };
    }
}