//
// Created by sines on 2021/2/9 .
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace BinarySearch {
    namespace L34_FindFirstandLastPositionofElementinSortedArray {
        using namespace std;

        class Solution : BaseSolution {
        private:
            vector<int> searchRange(vector<int>& nums, int target) {
                int len = nums.size();
                vector<int> ans;
                int l = 0, r = len - 1;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (nums[mid] == target) {
                        int i = mid - 1;
                        int j = mid + 1;
                        while (i >= 0 && nums[i] == target) i--;
                        while (j < len && nums[j] == target) j++;
                        return {i + 1, j - 1};
                    }
                    else if (nums[mid] < target) {
                        l = mid + 1;
                    }
                    else if (nums[mid] > target) {
                        r = mid - 1;
                    }
                }
                if (ans.empty()) ans = {-1, -1};
                return ans;
            }
        public:
            void run() override {
                vector<int> vc = {1,1};
                auto res = searchRange(vc, 1);
                OutputUtils::printVector(res);
            }
        };
    }
}