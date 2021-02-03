package Solutions.String.L161_OneEditDistance;

/**
 * 分类讨论
 */
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        int lenDiff = lens - lent;
        boolean res = false;
        // ensure s.length < t.length
        if (lent < lens)
            return isOneEditDistance(t, s);

        if (lenDiff > 1 || lenDiff < -1)
            return false;

        if (lenDiff == 1 || lenDiff == -1) {
            int i = 0, j = 0, counter = 0;
            if (lens == 0) return true;

            while (i < lens) {
                if (s.charAt(i) != t.charAt(j)) {
                    counter++;
                    if (counter > 1) return false;
                    j++;
                } else {
                    i++; j++;
                }
            }
            res = true;
        }

        if (lenDiff == 0) {
            if (lens == 0) return false;
            int i = 0, j = 0, counter = 0;
            while (i < lens) {
                if (s.charAt(i++) != t.charAt(j++))
                    if (counter++ == 1)
                        return false;
            }
            res = counter == 1;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.isOneEditDistance("ab", "acb");
        s.isOneEditDistance("ab", "ac");
        s.isOneEditDistance("a", "A");
        s.isOneEditDistance("", "A");
        s.isOneEditDistance("", "");
        s.isOneEditDistance("aaa", "aaaa");
    }
}
