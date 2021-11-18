//
// Created by qingshuihe on 2021/2/19 .
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace DP
{
    namespace L53_Maximum_Subarray
    {
        using namespace std;
        class Solution : BaseSolution
        {
        public:
            // find max
            int maxSubArray(vector<int> &nums)
            {
                if (nums.empty())
                    return 0;
                int dp[nums.size()];
                dp[0] = nums[0];
                int max = dp[0];
                for (int i = 1; i < nums.size(); ++i)
                {
                    if (dp[i - 1] > 0)
                    {
                        dp[i] = dp[i - 1] + nums[i];
                    }
                    else
                    {
                        dp[i] = nums[i];
                    }
                    if (max < dp[i])
                        max = dp[i];
                }
                return max;
            }

            // return indices
            pair<int, int> maxSubArray2(vector<int> &nums)
            {
                if (nums.empty())
                    return make_pair(0, 0);
                vector<int> dp(nums.size(), INT_MIN);
                dp[0] = nums[0];
                int max_end_index = 0;
                for (int i = 1; i < nums.size(); ++i)
                {
                    if (dp[i - 1] > 0)
                    {
                        dp[i] = dp[i - 1] + nums[i];
                    }
                    else
                    {
                        dp[i] = nums[i];
                    }
                    if (dp[max_end_index] < dp[i])
                        max_end_index = i;
                }

                for (int i = max_end_index; i >= 0; --i)
                {
                    if (dp[i] <= 0) 
                    {
                        return make_pair(i + 1, max_end_index);
                    }
                }
                return make_pair(0, max_end_index);
            }

            // if you pick nums[i], you can not pick nums[i-1] and nums[i+1], and you must pick at least one element
            int maxSubarray3(vector<int> &nums)
            {
                if (nums.empty()) return INT_MIN;
                if (nums.size() < 2) return nums[0];
                vector<int> dp(nums.size(), INT_MIN);
                dp[0] = nums[0];
                dp[1] = max(nums[1], nums[0]);
                for (int i = 2; i < nums.size(); ++i) {
                    dp[i] = max(max(dp[i-1], nums[i]), dp[i-2] + nums[i]);
                }
                return *max_element(dp.begin(), dp.end());
            }


            // maxSubarray3 recursive version
            int cnt = 0;
            int maxSubarray4(vector<int> &nums, vector<int> &dp, int n)
            {
                if (dp[n] != INT_MIN) return dp[n];
                if (n == 0) {
                    dp[n] = nums[0];
                } else if (n == 1) {
                    dp[n] = max(nums[0], nums[1]);
                } else {
                    dp[n] = max(max(nums[n], maxSubarray4(nums, dp, n-1)), maxSubarray4(nums, dp, n-2) + nums[n]);
                }
                cnt++;
                return dp[n];
            }

            void run()
            {
                vector<int> nums = {1,2,3,4,5,6,7,8,9,10,11};
                cout << maxSubArray(nums) << endl;
                cout << maxSubArray2(nums).first << " " << maxSubArray2(nums).second << endl;
                cout << maxSubarray3(nums) << endl;
                vector<int> dp(nums.size(), INT_MIN);
                cout << maxSubarray4(nums, dp, nums.size()-1) << endl;
                OutputUtils::printVector(dp);
                cout << cnt << endl;
            }
        };
    }
}