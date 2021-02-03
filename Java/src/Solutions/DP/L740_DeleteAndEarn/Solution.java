package Solutions.DP.L740_DeleteAndEarn;

public class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] points = new int[10001];
        for (int num : nums) {
            points[num] += num;
        }

        int[] dp = new int[10001];
        dp[0] = points[0];
        dp[1] = points[1];
        for (int i = 2; i < dp.length; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + points[i]);
        }
        return dp[dp.length - 1];
    }
}
