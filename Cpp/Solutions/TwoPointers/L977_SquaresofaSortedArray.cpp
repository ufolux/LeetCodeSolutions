//
// Created by Sines on 2021/2/5.
//

#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace L977_SquaresofaSortedArray {
    using namespace std;
    class Solution : BaseSolution {
    public:
        vector<int> sortedSquares(vector<int>& nums) {
            int len = nums.size();
            vector<int> ans(len);
            int l = 0, r = len - 1;
            int i = len - 1;
            while (l <= r) {
                if (abs(nums[l]) < abs(nums[r])) {
                    ans[i--] = nums[r] * nums[r];
                    r--;
                } else {
                    ans[i--] = nums[l] * nums[l];
                    l++;
                }
            }
            return ans;
        }

        void run() override {
            vector<int> nums = {-4,-1,0,3,10};
            for (auto n: sortedSquares(nums))
                cout << n << " " << endl;
        }
    };
};