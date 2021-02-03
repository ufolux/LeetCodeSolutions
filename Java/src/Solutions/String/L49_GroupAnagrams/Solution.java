package Solutions.String.L49_GroupAnagrams;

import java.util.*;

class Solution {
    /**
     * 排序解法
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String s : strs) {
            char[] carr = s.toCharArray();
            Arrays.sort(carr);
            String rstr = new String(carr);
            if (map.get(rstr) == null) {
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(rstr, l);
            } else {
                map.get(rstr).add(s);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }

    /**
     * 质数积解法
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        Map<Integer, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String s : strs) {
            char[] carr = s.toCharArray();
            int prod = 1;
            for (char c : carr) {
                prod = prod * primes[(c - 'a')];
            }
            if (map.get(prod) == null) {
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(prod, l);
            } else {
                map.get(prod).add(s);
            }
        }

        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.groupAnagrams1(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        s.groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
