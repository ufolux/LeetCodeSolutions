package Solutions.String.L246_StrobogrammaticNumber;

class Solution {
    public boolean isStrobogrammatic(String num) {
        char[] map = {'0', '1', ' ', ' ', ' ', ' ', '9', ' ', '8', '6'};

        for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            int l = num.charAt(i) - '0';
            char r = num.charAt(j);
            if (map[l] != r) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.isStrobogrammatic("69");
    }
}
