package Solutions.DP.L5666_PalindromePartitioningIV;

public class Solution {
    public boolean checkPartitioning(String s) {
        int length = s.length();
        // dp[i][j] represent if substring(i, j) is a palindrome string
        boolean[][] dp = new boolean[length][length];

        // 1. process only one and two characters substring
        for (int i = 0; i < length; ++i) {
            dp[i][i] = true;
            if (i < length - 1) {
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            }
        }

        // 2. process len > 2 substring
        for (int len = 3; len < length; ++len) {
            for (int l = 0; l + len - 1 < length; ++l) {
                int r = l + len - 1;
                if (s.charAt(l) == s.charAt(r) && dp[l + 1][r - 1]) {
                    dp[l][r] = true;
                }
            }
        }

        // 3. last divide s to 3 part and cal the result
        for (int l = 1; l <= length - 2; ++l) { // cos we need to divide s into 3 diff part, so it should start from 1 and end at length - 2
            for (int r = l; r <= length - 2; ++r) {
                if (dp[0][l - 1] && dp[l][r] && dp[r + 1][length - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
