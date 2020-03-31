package Solutions.String.L93_RestoreIPAddresses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        // base case
        if (s == null || len < 4 && len > 12) return res;
        StringBuilder sb = new StringBuilder();
        for  (int a = 1; a < 4; a++) {
            for (int b = 1; b < 4; b++) {
                for (int c = 1; c < 4; c++) {
                    for (int d = 1; d < 4; d++) {
                        if (a + b + c + d == s.length()) {
                            sb.setLength(0);
                            int n1 = Integer.parseInt(s.substring(0, a));
                            int n2 = Integer.parseInt(s.substring(a, a + b));
                            int n3 = Integer.parseInt(s.substring(a + b, a + b + c));
                            int n4 = Integer.parseInt(s.substring(a + b + c));
                            if (n1 < 256 && n2 < 256 && n3 < 256 && n4 < 256) {
                                sb.append(n1).append(".")
                                        .append(n2).append(".")
                                        .append(n3).append(".")
                                        .append(n4);
                                if (sb.length() == s.length() + 3) res.add(sb.toString());
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.restoreIpAddresses("25525511135").toArray()));
    }
}
