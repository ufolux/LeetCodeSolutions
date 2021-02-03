package Solutions.String.L14_LongestCommonPrefix;

import java.lang.reflect.Array;

class Solution {
    /**
     * 1.找出最短字符串
     * 2.遍历每个字符，看看每一位是否与最短字符串相同
     * 3.如果有不同就结束，如果都相同就把这一位的字符接到 comPre 后面
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
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

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.longestCommonPrefix1(new String[]{"aa", "a"});
        s.longestCommonPrefix2(new String[]{"aa", "a"});
    }
}
