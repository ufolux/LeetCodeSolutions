//
// Created by sines on 2021/2/8 .
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace Search_BFS_DFS_Backtrace {
    namespace L77_Combinations {
        using namespace std;

        class Solution : BaseSolution {
        private:
            void dfs(vector<vector<int>> &ans, vector<int> &tmp, int n, int k, int start) {
                if (k == tmp.size()) {
                    ans.push_back(tmp);
                    return;
                }
                // branch cutting, k - tmp.size() means there is not enough elements in the rest of the sequence to form a size k array
                // so cut this branch to save computation
                for (int i = start; i <= n && k - tmp.size() <= n - i + 1; i++) {
                    tmp.push_back(i);
                    dfs(ans, tmp, n, k, i + 1);
                    tmp.pop_back();
                }
            }

            vector<vector<int>> combine(int n, int k) {
                vector<vector<int>> ans;
                vector<int> tmp;
                dfs(ans, tmp, n, k, 1);
                return ans;
            }
        public:
            void run() override {
                auto ans = combine(4, 2);
                OutputUtils::printMatrix(ans);
            }
        };
    }
}