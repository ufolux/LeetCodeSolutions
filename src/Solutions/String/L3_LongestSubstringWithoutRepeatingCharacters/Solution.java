package Solutions.String.L3_LongestSubstringWithoutRepeatingCharacters;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int leftIndex = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int innerIndex = leftIndex; innerIndex < i; innerIndex++) {
                if (chars[innerIndex] == chars[i]) {
                    maxLength = Math.max(maxLength, i - leftIndex);
                    leftIndex = innerIndex + 1;
                }
            }
        }
        return Math.max(maxLength, chars.length - leftIndex);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int len = s.lengthOfLongestSubstring("abcabcbb");
        System.out.println(len);
    }
}
