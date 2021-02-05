//
// Created by Sines on 2021/2/4.
//

#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace TwoPointers {
    namespace L986_IntervalListIntersections {
    using namespace std;
    class Solution : BaseSolution {
    public:
        vector<vector<int>> intervalIntersection(vector<vector<int>>& firstList, vector<vector<int>>& secondList) {
            if (firstList.size() == 0 || secondList.size() == 0) {
                return {};
            }

            int len1 = firstList.size();
            int len2 = secondList.size();
            vector<vector<int>> ans;
            for (int i = 0, j = 0; i < len1 && j < len2;) {
                vector<int> v1 = firstList[i];
                vector<int> v2 = secondList[j];
                int start = max(v1[0], v2[0]);
                int end = min(v1[1], v2[1]);
                if (end >= start) {
                    ans.emplace_back(initializer_list<int>{start, end});
                }
                if (v1[1] > v2[1]) {
                    j++;
                } else {
                    i++;
                }
            }
            return ans;
        }

        void run() override {
            auto v1 = vector<vector<int>>{{4,6},{7,8},{10,17}};
            auto v2 = vector<vector<int>>{{5,10}};
            auto res = intervalIntersection(v1, v2);
            for (auto& it: res) {
                cout << it[0] << " " << it[1] << endl;
            }
        }
    };
};
}
