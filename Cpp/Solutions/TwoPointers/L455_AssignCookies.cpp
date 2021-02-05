//
// Created by Sines on 2021/2/3.
//

#include <Solutions/BaseSolution.h>
#include "PublicHeaders.h"
namespace TwoPointers {
    namespace L455_AssignCookies {
    using namespace std;
    class Solution: BaseSolution {
    public:
        int findContentChildren(vector<int> &g, vector<int> &s) {
            sort(g.begin(), g.end());
            sort(s.begin(), s.end());
            int glen = g.size();
            int slen = s.size();
            int ans = 0;
            for (int i = 0, j = 0; i < glen && j < slen;) {
                if (g[i] <= s[j]) {
                    ans++;
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
            return ans;
        }


    };
};
}
