package Solutions.String.L249_GroupShiftedStrings;

import java.util.*;

public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            char[] chars = s.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (int j = 1; j < chars.length; j++) {
                sb.append((chars[j] - chars[j - 1] + 26) % 26);
                sb.append(',');
            }
            String key = sb.toString();
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> strs = new ArrayList<>();
                strs.add(s);
                map.put(key, strs);
            }
        }
        List<List<String>> res = new ArrayList<>();
        res.addAll(map.values());
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"});
    }
}
