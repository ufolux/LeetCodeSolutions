package Solutions.DP.L72_EditDistance;

class Solution {
    public int minDistance1(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        // base case
        if (l1 * l2 == 0)
            return l1 + l2;
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i < l1 + 1; i++)
            dp[i][0] = i;
        for (int i = 0; i < l2 + 1; i++)
            dp[0][i] = i;

        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // 不需要做任何修改，步骤数与 [i - 1][j - 1] 相同
                } else {
                    dp[i][j] = Math.min(
                            dp[i - 1][j] + 1, // 对 word1 进行【删除】操作，步骤数在 [i - 1][j] 子问题上加一
                            Math.min(
                                    dp[i - 1][j - 1] + 1, // 对 word1 进行【替换】操作，步骤数在 [i - 1][j - 1] 子问题上加一
                                    dp[i][j - 1] + 1 // 对 word1 进行【插入】操作，步骤数在 [i][j - 1] 子问题上加一
                            )
                    );
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public int minDistance2(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        // base case
        if (n * m == 0)
            return n + m;
        int[] dp = new int[m + 1];
        for (int i = 0; i < dp.length; i++) dp[i] = i;
        for (int i = 1; i < n + 1; i++) {
            int pre = i - 1;
            for (int j = 1; j < m + 1; j++) {
                if (j == 1) dp[j - 1] = i;
                int temp = pre;
                pre = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = temp;
                } else {
                    dp[j] = Math.min(temp, Math.min(dp[j - 1], dp[j])) + 1;
                }
            }
        }
        return dp[dp.length - 1];
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minDistance1("edple", "apple"));
        System.out.println(s.minDistance2("edple", "apple"));
    }
}
