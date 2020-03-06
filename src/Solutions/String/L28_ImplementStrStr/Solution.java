package Solutions.String.L28_ImplementStrStr;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        int i = 0, j = 0, idx = -1;
        for (; i < haystack.length();) {
            idx = i;
            while (i < haystack.length() && haystack.charAt(i++) == needle.charAt(j++)) {
                if (j == needle.length()) {
                    return idx;
                }
            }
            i = idx + 1;
            j = 0;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.strStr("mississippi", "issipi");
    }
}
