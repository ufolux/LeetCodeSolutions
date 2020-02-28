package Solutions.String.L387_FirstUniqueCharacterInAString;

/**
 * ASCII Code as index
 */
class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int times = map[c - 'a'];
            if (times == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.firstUniqChar("leetcode");
    }
}
