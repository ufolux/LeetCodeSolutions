//
// Created by sines on 2022/2/25 .
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace String {
    namespace L249_GroupShiftedStrings {
        using namespace std;

        class Solution : BaseSolution {
        private:
            bool isShiftedStr(string& s1, string& s2) {
                for (int j = 1; j < s1.size(); ++j) {
                    if (s1[j] - s2[j] != s1[j - 1] - s2[j - 1]) return false;
                }
                return true;
            }
        public:
            vector<vector<string>> groupStrings(vector<string>& strings) {
                unordered_map<int, vector<string>> lenMap;
                for (auto s: strings) {
                    lenMap[s.size()].push_back(s);
                }
                vector<vector<string>> res;
                for (auto& kv: lenMap) {
                    vector<string>& strs = kv.second;
                    vector<string> grp;
                    for (int i = 0; i < strs.size(); ++i) {
                        string& s1 = strs[i - 1];
                        if (s1.empty()) continue;
                        for (int j = i + 1; j < strs.size(); ++j) {
                            string& s2 = strs[i];
                            if (isShiftedStr(s1, s2)) {
                                grp.push_back(s2);
                                strs[i] = "";
                            }
                        }
                        if (!grp.empty()) {
                            grp.push_back(s1);
                            res.push_back(grp);
                        }
                    }
                }
                return res;
            }

            void run() override {
                vector<string> strings = {"abc","bcd","acef","xyz","az","ba","a","z"};
                auto res = groupStrings(strings);
                OutputUtils::printVector(res);
            }
        };
    }
}