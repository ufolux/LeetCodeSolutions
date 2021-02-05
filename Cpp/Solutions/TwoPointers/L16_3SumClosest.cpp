//
// Created by Sines on 2021/2/5.
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace L16_3SumClosest {
    using namespace std;
    class Solution : BaseSolution {
    public:
        int threeSumClosest(vector<int>& nums, int target) {
            sort(nums.begin(), nums.end());
            int len = nums.size();
            int min_diff = INT_MAX;
            int ans = 0;
            for (int i = 0; i < len; ++i) {
                int l = i + 1;
                int r = len - 1;
                int t = target - nums[i];
                while (l < r) {
                    int sum = nums[l] + nums[r] + nums[i];
                    int diff = sum - target;
                    if (abs(diff) < min_diff) {
                        min_diff = abs(diff);
                        ans = sum;
                    }
                    if (target < sum) {
                        r--;
                    } else if (target == sum){
                        return ans;
                    } else {
                        l++;
                    }
                }
            }
            return ans;
        }

        void run() override {
            vector<int> vec = {-1,2,1,-4,5,-2,-10,10,30,3,4,5};
            cout << threeSumClosest(vec, 10) << endl;
        }
    };
};