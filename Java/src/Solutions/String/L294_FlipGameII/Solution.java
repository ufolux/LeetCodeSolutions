package Solutions.String.L294_FlipGameII;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean canWin(String s) {
        if(s == null || s.length() == 0) return false;
        int consPlus = 0, tempPlus = 0;
        for (int i = 0, j = 1; j < s.length(); i++, j++) {
            if (s.charAt(i) == '+' && s.charAt(j) == '+') {
                consPlus++;
            }
        }

        if (++consPlus % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.canWin("+++++++");
    }
}
