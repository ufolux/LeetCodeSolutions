package Solutions.DP.L140_WordBreakII;

import java.util.*;

public class Solution {
    private Set<String> wordSet;
    private int maxL = 0;
    private void genAns(String s, List<String> ans, Stack<String> tmp) {
        int len = s.length();
        if (len == 0) {
            StringBuilder sb = new StringBuilder();
            tmp.forEach((str)->sb.append(str).append(" "));
            sb.setLength(sb.length() - 1);
            ans.add(sb.toString());
            tmp.pop();
            return;
        }
        for (int i = 0; i <= Math.min(maxL, len); ++i) {
            String subStr = s.substring(0, i);
            if (wordSet.contains(subStr)) {
                tmp.push(subStr);
                genAns(s.substring(i, len), ans, tmp);
            }
        }
        if (!tmp.isEmpty()) tmp.pop();
    }

    private boolean canBreak(String s) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j <= Math.min(i + maxL, len); ++j) {
                String subStr = s.substring(i, j);
                if (dp[i] && wordSet.contains(subStr)) {
                    dp[j] = true;
                }
            }
        }
        return dp[len];
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        Optional<String> var = wordDict.stream().max(Comparator.comparingInt(String::length));
        var.ifPresent(value -> maxL = value.length());
        List<String> ans = new ArrayList<>();
        if (!canBreak(s)) return ans;
        Stack<String> tmp = new Stack<>();
        genAns(s, ans, tmp);
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        var ans = s.wordBreak("catsanddoog", Arrays.asList("ca", "c", "at", "doog", "a", "t", "cat","cats","and","sand","dog"));
        ans.forEach(System.out::println);
    }
}
