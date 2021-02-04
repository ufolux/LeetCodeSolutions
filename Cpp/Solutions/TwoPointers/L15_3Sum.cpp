//
// Created by Sines on 2021/2/5.
//

#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace L15_3Sum {
    using namespace std;
    class Solution : BaseSolution {
    public:
        vector<vector<int>> threeSum(vector<int>& nums) {
            sort(nums.begin(), nums.end());
            int len = nums.size();
            if (len < 3) return {};
            vector<vector<int>> ans;
            for (int i = 0; i < nums.size(); ++i) {
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;
                int l = i + 1, r = len - 1;
                int target = -nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == target) {
                        ans.push_back({nums[l], nums[i], nums[r]});
                        while (l < r && nums[r - 1] == nums[r]) r--;
                        while (l < r && nums[l + 1] == nums[l]) l++;
                        r--;
                        l++;
                    } else if (nums[l] + nums[r] > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
            return ans;
        }

        void run() override {
            vector<int> src = {0,0,0,0};
            auto res = threeSum(src);
            for (auto& v: res) {
                for (auto& e: v) {
                    cout << e << " ";
                }
                cout << endl;
            }
        }
    };
}
