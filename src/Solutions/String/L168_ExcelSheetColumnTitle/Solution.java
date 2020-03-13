package Solutions.String.L168_ExcelSheetColumnTitle;

import java.util.Stack;

class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char)('A' + n % 26));
            n /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.convertToTitle(701);
    }
}
