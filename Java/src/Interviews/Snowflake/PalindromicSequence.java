package Interviews.Snowflake;

import java.util.List;

public class PalindromicSequence {
    int multiplyPalindrome(String s) {
        int n=s.length(),m=0;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) dp[i][i]=1;

        for (int cl=2; cl<=n; cl++) {
            for (int i=0; i<n-cl+1; i++){
                int j = i+cl-1;
                if (s.charAt(i) == s.charAt(j) && cl == 2) dp[i][j] = 2;
                else if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1] + 2;
                else dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
            }
        }
        for(int i=0;i<n-1;i++){
            m = Math.max( m, dp[0][i]*dp[i+1][n-1] );
        }
        return m;
    }

    public static void main(String[] args) {
        PalindromicSequence ps = new PalindromicSequence();
        ps.multiplyPalindrome("attract");
    }
}
