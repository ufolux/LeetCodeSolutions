package Solutions.String.L567_PermutationInString;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    boolean checkIsMatch (String s1, Map<Character, Integer> map) {
        for (Character key: map.keySet()) {
            Integer cnt = map.get(key);
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 1957ms lowb 算法
     * 滑动 s1 窗口，用 map 进行全排列匹配
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion1(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();

        outer:
        for (int i = 0, j = s1.length() + i; j <= s2.length();) {
            for (int k = i; k < j; k++) {
                map.put(s2.charAt(k), map.getOrDefault(s2.charAt(k), 0) + 1);
            }
            for (int k = 0; k < s1.length(); k++) {
                Integer cnt = map.get(s1.charAt(k));
                if (cnt != null) {
                    map.put(s1.charAt(k), --cnt);
                } else {
                    // move window
                    map.clear();
                    i++; j++;
                    continue outer;
                }
            }
            if (!checkIsMatch(s1, map)) {
                map.clear();
                i++; j++;
            } else {
                return true;
            }
        }
        return false;
    }

    boolean checkIsMatch (char[] s1Map, char[] s2Map) {
        for (int i = 0; i < s1Map.length; i++) {
            if (s1Map[i] != s2Map[i]) return false;
        }
        return true;
    }

    public boolean checkInclusion2(String s1, String s2) {
        char[] s1c = s1.toCharArray(), s2c = s2.toCharArray();
        int s1_len = s1.length(), s2_len = s2.length();
        if (s1_len > s2_len) return false;

        char[] s1_map = new char[26], s2_map = new char[26];
        for (int i = 0; i < s1_len; i++) {
            ++s1_map[s1c[i] - 'a'];
            ++s2_map[s2c[i] - 'a'];
        }

        for (int i = s1_len; i < s2_len; i++) {
            if (checkIsMatch(s1_map, s2_map)) return true;
            --s2_map[s2c[i - s1_len] - 'a'];
            ++s2_map[s2c[i] - 'a'];
        }
        return checkIsMatch(s1_map, s2_map);
    }


    public boolean checkInclusion3(String s1, String s2) {
        char[] s1c = s1.toCharArray(), s2c = s2.toCharArray();
        int s1_len = s1.length(), s2_len = s2.length();
        if (s1_len > s2_len) return false;

        char[] s1_map = new char[26], s2_map = new char[26];
        for (int i = 0; i < s1_len; i++) {
            ++s1_map[s1c[i] - 'a'];
            ++s2_map[s2c[i] - 'a'];
        }

        for (int i = s1_len, j = i - s1_len; i < s2_len; i++, j++) {
            if (checkIsMatch(s1_map, s2_map)) return true;
            --s2_map[s2c[j] - 'a'];
            ++s2_map[s2c[i] - 'a'];
        }
        return checkIsMatch(s1_map, s2_map);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.checkInclusion1("ab", "eidbaooo");
        s.checkInclusion2("ab", "eidbaooo");
        s.checkInclusion3("ab", "eidbaooo");
    }
}
