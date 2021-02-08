//
// Created by sines on 2021/2/8 .
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace Search_BFS_DFS_Backtrace {
    namespace L784_LetterCasePermutation {
        using namespace std;

        class Solution : BaseSolution {
        private:
            unordered_set<string> st;
            vector<string> ans;
            void dfs(string& S, int n) {
                int len = S.size();
                if (len == n) {
                    ans.emplace_back(S);
                } else {
                    if (!isalpha(S[n])) {
                        dfs(S, n + 1);
                    } else {
                        S[n] = tolower(S[n]);
                        dfs(S, n + 1);
                        S[n] = toupper(S[n]);
                        dfs(S, n + 1);
                    }
                }
            }
            vector<string> letterCasePermutation(string S) {
                dfs(S, 0);
                return ans;
            }
        public:
            void run() override {
                auto res = letterCasePermutation("a1b1");
                OutputUtils::printVector(res);
            }
        };
    }
}