package Interviews.Snowflake;

import java.util.ArrayList;
import java.util.List;

public class ReconstructingArray {
    // Reconstructing Array HackerRank
    public static List<Integer> solve(List<Integer> n, List<Integer> m, List<Integer> totalCost) {
        int MAXN = 55;
        int MAXM = 105;
        int MAXCOST = 55;
        double MOD = 1e9 + 7;
        List<Integer> finalOutput = new ArrayList<Integer>();

        for(int ar = 0 ; ar < n.size() ; ar++) {
            int nValue = n.get(ar);
            int mValue = m.get(ar);
            int costValue = totalCost.get(ar);

            int cum[][][]=new int[MAXN][MAXM][MAXCOST];
            long dp[][][]=new long [MAXN][MAXM][MAXCOST];
            for (int j = 1; j <= m.get(ar); j++) {
                dp[1][j][0] = 1;
                cum[1][j][0] = j;
            }

            for (int i = 2; i <= nValue; i++) {
                for (int j = 1; j <= mValue; j++) {
                    for (int k = 0; k <= costValue; k++) {
                        dp[i][j][k] = (j * dp[i - 1][j][k]);
                        dp[i][j][k] %= MOD;
                        if(k!= 0)
                            dp[i][j][k] += cum[i - 1][j - 1][k-1];
                        dp[i][j][k] %= MOD;
                        cum[i][j][k] = (int)((cum[i][j - 1][k] + dp[i][j][k])%MOD);
                    }
                }
            }
            finalOutput.add(cum[nValue][mValue][costValue]);
        }
        return finalOutput;
    }

    public static void main(String[] args) {
        List<Integer> n = new ArrayList<>();
        n.add(2);
        n.add(3);
        n.add(4);
        List<Integer> m = new ArrayList<>();
        m.add(3);
        m.add(3);
        m.add(3);
        List<Integer> totalCost = new ArrayList<>();
        totalCost.add(1);
        totalCost.add(2);
        totalCost.add(2);
        List<Integer> finalOutput = solve(n, m, totalCost);
        for (int i = 0; i < finalOutput.size(); i++)
            System.out.println(finalOutput.get(i));
    }
}
