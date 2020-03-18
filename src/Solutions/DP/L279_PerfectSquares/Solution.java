package Solutions.DP.L279_PerfectSquares;

/**
 * https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51584790
 */
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j*j >= 0; j++) {
                // 每个完美平方数都是由一个完全平方数和一个普通数字组成
                // +1 指的是一个完全平方数
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.numSquares(12);
    }
}
