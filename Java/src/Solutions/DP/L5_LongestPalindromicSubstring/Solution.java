package Solutions.DP.L5_LongestPalindromicSubstring;

class Solution {
    boolean isPalindromic (String s) {
        if (s == null || s.length() == 0) return true;
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    /**
     * 暴力法
     * 时间超限 O(n^3)
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        int[] dp = new int[s.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindromic(s.substring(j, i))) {
                    int len = i - j;
                    dp[i] = Math.max(dp[i], Math.max(dp[i - 1], len));
                }
            }
        }
        int maxL = dp[dp.length - 1];
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == maxL) {
                return s.substring(i - dp[i], i);
            }
        }
        return "";
    }

    int expandAroundCenter (String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    /**
     * expandAroundCenter
     * 中心扩展法 O(n^2)
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.longestPalindrome1("abba");
        s.longestPalindrome2("abba");
    }
}

