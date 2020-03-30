package Solutions.String.L409_LongestPalindrome;

class Solution {
    public int longestPalindrome(String s) {
        int[] map = new int['z' - 'A'];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'A']++;
        }
        int count = 0;
        int odd = 0;
        for (int i = 0; i < map.length; i++) {
            int fre = map[i];
            if (fre != 0) {
                if (fre % 2 == 0) {
                    count += fre;
                } else {
                    count += fre - 1;
                    odd = 1;
                }
            }
        }
        count += odd;
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.longestPalindrome("ccd");
    }
}
