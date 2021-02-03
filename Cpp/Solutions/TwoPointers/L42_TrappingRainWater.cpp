//
// Created by Sines on 2021/2/3.
//
#include "PublicHeaders.h"
#include "../BaseSolution.h"

namespace L42_TrappingRainWater {
    using namespace std;
    class Solution: BaseSolution {
    public:
        int trap(vector<int>& height) {
            int len = height.size();
            if (len == 0) return 0;
            int l[len], r[len];
            memset(l, 0, sizeof(l));
            memset(r, 0, sizeof(r));
            // 1. pre-calculate 0~i max height
            for (int i = 0; i < len; ++i)
                l[i] = i == 0 ? height[i] : max(l[i - 1], height[i]);
            // 2. pre-calculate i~len max height
            for (int i = len - 1; i >= 0; --i)
                r[i] = i == len - 1 ? height[i] : max(r[i + 1], height[i]);
            // 3. calculate min(maxHeight(0~i), maxHeight(i~len));
            int sum = 0;
            for (int i = 0; i < len; ++i)
                sum += min(l[i], r[i]) - height[i];
            return sum;
        }

        void run() override {
            vector<int> h = {0,1,0,2,1,0,1,3,2,1,2,1};
            cout << trap(h) << endl;
        }
    };
};
