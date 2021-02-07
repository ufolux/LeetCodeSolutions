//
// Created by sines on 2021/2/7 .
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace Search_BFS_DFS_Backtrace {
    namespace L17_LetterCombinationsofAPhoneNumber {
        using namespace std;

        class Solution : BaseSolution {
        private:
            vector<vector<char>> cmap = {
                    {'a', 'b', 'c'},
                    {'d', 'e', 'f'},
                    {'g', 'h', 'i'},
                    {'j', 'k', 'l'},
                    {'m', 'n', 'o'},
                    {'p', 'q', 'r', 's'},
                    {'t', 'u', 'v'},
                    {'w', 'x', 'y', 'z'},
            };
            void dfs(string &digits, int curIdx, string &curAns, vector<string> &ans) {
                if (curIdx == digits.size()) {
                    ans.push_back(curAns);
                    return;
                }
                vector<char> vc = cmap[digits[curIdx] - '2'];
                for (char c: vc) {
                    curAns += c;
                    dfs(digits, curIdx + 1, curAns, ans);
                    curAns.erase(curAns.size() - 1);
                }
            }
            vector<string> letterCombinations(string digits) {
                if (digits.length() == 0) return {};
                vector<string> ans;
                int len = digits.length();
                string tmp;
                dfs(digits, 0, tmp, ans);
                return ans;
            }
        public:
            void run() override {
                vector<string> ans = letterCombinations("123");
                OutputUtils::printVector(ans);
            }
        };
    }
}