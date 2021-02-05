//
// Created by Sines on 2021/2/5.
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace TwoPointers {
    namespace L992_SubarrayswithKDifferentIntegers {
    using namespace std;
    class Solution : BaseSolution {
    public:
        int subarraysWithKDistinct(vector<int>& A, int K) {
            int len = A.size();
            if (len == 1) return K == 1 ? 1 : 0;
            int l = 0, r = l;
            unordered_set<int> st;
            int count = 0;
            while (l <= r && r < len) {
                int n = A[r];
                if (st.size() == K) {
                    if (!st.count(n)) {
                        l++;
                        r = l;
                        st.clear();
                    } else {
                        count++;
                        r++;
                    }
                } else {
                    st.insert(n);
                    if (st.size() == K) count++;
                    r++;
                }
            }
            return count;
        }

        void run() override {
            vector<int> vec = {1,2,1,2,3};
            int K = 2;
            int res = subarraysWithKDistinct(vec, K);
            cout << res << endl;
        }
    };
};
}
