package Solutions.DP.L53_MaximumSubarray;

import java.util.List;

public class Solution {
    int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num: nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(sum, res);
        }
        return res;
    }
}
