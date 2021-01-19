package Solutions.DP.L70_ClimbingStairs;

public class Solution {
    public int climbStairs(int n) {
        int dp1 = 0;
        int dp2 = 0;
        int r = 1;
        for (int i = 1; i <= n; ++i) {
            dp1 = dp2;
            dp2 = r;
            r = dp1 + dp2;
        }
        return r;
    }
}
