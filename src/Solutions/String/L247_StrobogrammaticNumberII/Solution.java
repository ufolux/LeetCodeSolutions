package Solutions.String.L247_StrobogrammaticNumberII;

import java.util.*;

class Solution {
    /**
     * recursive
     * @param n
     * @return
     */
    public List<String> find (int n) {
        if (n == 1) {
            var list = new ArrayList<String>();
            list.add("0");
            list.add("1");
            list.add("8");
            return list;
        }

        if (n == 2) {
            var list = new ArrayList<String>();
            list.add("00");
            list.add("11");
            list.add("88");
            list.add("69");
            list.add("96");
            return list;
        }

        var sub = find(n - 2);
        var res = new ArrayList<String>();

        for (String s: sub) {
            StringBuilder sb = new StringBuilder();
            res.add(sb.append("0").append(s).append("0").toString());
            sb.setLength(0);
            res.add(sb.append("1").append(s).append("1").toString());
            sb.setLength(0);
            res.add(sb.append("8").append(s).append("8").toString());
            sb.setLength(0);
            res.add(sb.append("6").append(s).append("9").toString());
            sb.setLength(0);
            res.add(sb.append("9").append(s).append("6").toString());
        }

        return res;
    }

    public List<String> findStrobogrammatic1(int n) {
        if (n == 1) {
            var list = new ArrayList<String>();
            list.add("0");
            list.add("1");
            list.add("8");
            return list;
        }

        if (n == 2) {
            var list = new ArrayList<String>();
            list.add("00");
            list.add("11");
            list.add("88");
            list.add("69");
            list.add("96");
            return list;
        }
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        var sub = find(n-2);
        for (String s: sub) {
            StringBuilder sb = new StringBuilder();
            res.add(sb.append("1").append(s).append("1").toString());
            sb.setLength(0);
            res.add(sb.append("8").append(s).append("8").toString());
            sb.setLength(0);
            res.add(sb.append("6").append(s).append("9").toString());
            sb.setLength(0);
            res.add(sb.append("9").append(s).append("6").toString());
        }
        return res;
    }

    /**
     * DFS
     */
    private static char[] symmetricMap = new char[] {
            '0','1','*','*','*','*','9','*','8','6'
    };

    public List<String> findStrobogrammatic2(int n) {
        List<String> res = new ArrayList<>();
        dfs(1, n - 2, new char[n], res);
        return res;
    }

    public void dfs(int head, int rear, char[] chars, List<String> res) {
        if (head > rear) {
            if (chars.length == 1 || chars[0] != '0') {
                res.add(new String(chars));
            }

            return;
        }
        for (char c = '0'; c < '9' + 1; c++) {
            char symmetricChar = symmetricMap[ c - '0'];
            if (symmetricChar != '*') {

                if (head != rear) {
                    chars[head] = c;
                    chars[rear] = symmetricChar;
                    dfs(head+1, rear -1, chars, res);
                } else if (symmetricChar == c) {
                    chars[head] = c;
                    dfs(head+1, rear -1, chars, res);
                }

            }
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        var list = s.findStrobogrammatic1(10);
        System.out.println(Arrays.toString(list.toArray()));

        list = s.findStrobogrammatic2(10);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
