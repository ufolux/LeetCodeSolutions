//
// Created by Sines on 2021/2/3.
//
#include "PublicHeaders.h"
#include "../BaseSolution.h"
namespace DP {
    namespace L140_WordBreakII {
        using namespace std;

        class Solution: BaseSolution {
        private:
            unordered_set<string> wordSet;
            vector<string> tmp;
            int maxL = 0;

            bool canBreak(vector<string> &wordDict, string s) {
                unordered_set<string> wordSet(wordDict.begin(), wordDict.end());
                int n = (int) s.size();
                vector<bool> dp(n + 1, false);
                dp[0] = true;
                for (int i = 0; i < n; ++i) {
                    for (int j = i + 1; j <= min(i + maxL, n); ++j) {
                        if (dp[j]) continue;
                        string subs = s.substr(i, j - i);
                        if (dp[i] && wordSet.count(subs)) {
                            dp[j] = true;
                        }
                    }
                }
                return dp[n];
            }

            void helper(vector<string> &ans, string &s, vector<string> &tmp, int level) {
                int len = (int) s.size();
                if (len == 0) {
                    string res;
                    for (auto str: tmp) {
                        res.append(str).append(" ");
                    }
                    res.erase(res.end() - 1);
                    ans.push_back(res);
                    tmp.pop_back();
                    return;
                }
                for (int i = 1; i <= min(maxL, len); ++i) {
                    string subs = s.substr(0, i);
                    if (wordSet.count(subs)) {
                        tmp.push_back(subs);
                        string restStr = s.substr(i, len - i + 1);
                        helper(ans, restStr, tmp, level + 1);
                    }
                }
                if (tmp.size()) tmp.pop_back();
            }

        public:
            vector<string> wordBreak(string s, vector<string> &wordDict) {
                copy(wordDict.begin(), wordDict.end(), inserter(wordSet, wordSet.begin()));
                for (auto str: wordDict) {
                    maxL = max(maxL, (int) str.length());
                }
                if (!canBreak(wordDict, s)) {
                    return {};
                }
                vector<string> ans;
                vector<string> tmp;
                helper(ans, s, tmp, 0);
                return ans;
            }

            void run() {
                vector<string> words = {"apple","pen","applepen","pine","pineapple"};
                auto res = wordBreak("pineapplepenapple", words);
                OutputUtils::printVector(res);
            }
        };
    }
}