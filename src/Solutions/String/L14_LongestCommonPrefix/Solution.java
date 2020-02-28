package Solutions.String.L14_LongestCommonPrefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String minStr = ""; int minLen = Integer.MAX_VALUE;
        String ans = "";
        for (int i = 0; i < strs.length; i++) {
            int tempMin = minLen;
            minLen = Math.min(minLen, strs[i].length());
            minStr = tempMin == minLen ? minStr : strs[i];
        }

        String comPre = "";
        for (int i = 0; i < minLen; i++) {
            char c = minStr.charAt(i);
            for (String s: strs) {
                if (c != s.charAt(i)) {
                    return comPre;
                }
            }
            comPre += c;
        }
        return comPre;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.longestCommonPrefix(new String[]{"aa", "a"});
    }
}
