//
// Created by Sines on 2021/2/3.
//
#include "PublicHeaders.h"
#include "../BaseSolution.h"

namespace TwoPointers {
    namespace L11_ContainerWithMostWater {
    using namespace std;
    class Solution: BaseSolution {
    public:
        int maxArea(vector<int> &height) {
            int len = height.size();
            int maxArea = 0;
            for (int i = 0, j = len - 1; i < j;) {
                maxArea = max(maxArea, min(height[i], height[j]) * (j - i));
                if (height[i] > height[j]) {
                    j--;
                } else {
                    i++;
                }
            }
            return maxArea;
        }

        void run() {
            vector<int> heights = {1,8,6,2,5,4,8,3,7};
            int ans = maxArea(heights);
            cout << ans << endl;
        }
    };
};
}
