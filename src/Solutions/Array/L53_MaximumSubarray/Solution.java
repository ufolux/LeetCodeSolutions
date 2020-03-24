package Solutions.Array.L53_MaximumSubarray;

public class Solution {
    /**
     * greedy algorithm
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int sum = 0;
        int res = nums[0];
        for (int n: nums) {
            sum += n;
            res = Math.max(res, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return res;
    }

    /**
     * DP Algorithm
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        int res = nums[0];
        dp[0] = res;
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * Optimize DP Algorithm
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums) {
        int res = nums[0];
        int pre = res;
        for (int i = 1; i < nums.length; i++) {
            if (pre < 0) {
                pre = nums[i];
            } else {
                pre = pre + nums[i];
            }
            res = Math.max(res, pre);
        }
        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxSubArray1(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        s.maxSubArray1(new int[]{-2,-1});
        s.maxSubArray2(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        s.maxSubArray2(new int[]{-2,-1});
        s.maxSubArray3(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        s.maxSubArray3(new int[]{-2,-1});
    }
}
