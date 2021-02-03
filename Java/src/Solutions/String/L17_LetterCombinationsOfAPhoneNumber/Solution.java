package Solutions.String.L17_LetterCombinationsOfAPhoneNumber;
/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

import java.util.*;

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;

        Map<Character, char[]> map = new HashMap<>() {{
            put('1', new char[]{});
            put('2', new char[]{'a', 'b', 'c'});
            put('3', new char[]{'d', 'e', 'f'});
            put('4', new char[]{'g', 'h', 'i'});
            put('5', new char[]{'j', 'k', 'l'});
            put('6', new char[]{'m', 'n', 'o'});
            put('7', new char[]{'p', 'q', 'r', 's'});
            put('8', new char[]{'t', 'u', 'v'});
            put('9', new char[]{'w', 'x', 'y', 'z'});
        }};

        char[] carr = digits.toCharArray();
        StringBuffer sb = new StringBuffer();
        dfs(sb, map, carr,0, res);
        return res;
    }

    void dfs (StringBuffer cur, Map<Character, char[]> map, char[] digit, int start, List<String> res) {
        if (start == digit.length) {
            res.add(cur.toString());
        } else {
            // dfs
            char[] letters = map.get(digit[start]);
            for (int i = 0; i < letters.length; i++) {
                cur.append(letters[i]);
                dfs(cur, map, digit, start + 1, res);
                cur.setLength(cur.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        var list = s.letterCombinations("23");
        System.out.print(Arrays.toString(list.toArray()));
    }
}
// @lc code=end

