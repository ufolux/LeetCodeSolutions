package Solutions.DP.L139_WordBreak;

import java.util.*;

class Solution {
    /**
     * 子问题：前 i 个字母组成的字符串是否可分
     * 解决子问题需要从头开始查询子串是否可分
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        int maxL = 0;
        for (String str: wordDict) {
            maxL = Math.max(maxL, str.length());
            set.add(str);
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = Math.max(i - maxL, 0); j < i; j++) {
                // dp[j] 可分且 sub(j, i) 可分，那么 sub(0, i)可分
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.wordBreak("leetcode", Arrays.asList("leet", "code"));
    }
}
