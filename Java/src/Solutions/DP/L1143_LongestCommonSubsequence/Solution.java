package Solutions.DP.L1143_LongestCommonSubsequence;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[] dp = new int[len2 + 1];           //数组大小有初始化时，数组中的默认值为0；
        char[] t1 = text1.toCharArray();        //先把String转化为char数组，数组索引取字符，执行用时比String用charAt要短
        char[] t2 = text2.toCharArray();
        for(int i = 1; i <= len1; i++){
            int last = 0;
            for(int j = 1; j <= len2; j++){
                int tmp = dp[j];
                if(t1[i - 1] == t2[j - 1]){
                    dp[j] = last + 1;
                }else{
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                last = tmp;
            }
        }
        return dp[len2];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.longestCommonSubsequence("abcde", "ace");
    }
}
