package Solutions.String.L358_RearrangeStringKDistanceApart;

import java.util.*;

public class Solution {
    /**
     * 1. use map to cal letter frequency
     * 2. use heap (PQ) to get highest freq letter every time
     * @param s
     * @param k
     * @return
     */
    public String rearrangeString(String s, int k) {
        if (k <= 1 || s.length() < k) return s;

        int[] map = new int[26];
        for (char c: s.toCharArray()) {
            map[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder("");
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) heap.offer(new int[]{i, map[i]});
        }

        while (!heap.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                int[] cur = heap.poll();
                sb.append((char)(cur[0] + 'a'));
                list.add(cur[0]);

                if (heap.isEmpty()) {
                    if (i != k - 1 && sb.length() != s.length()) return "";
                    break;
                }
            }

            for (int i: list) {
                if (--map[i] > 0) {
                    heap.offer(new int[]{i, map[i]});
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rearrangeString("aabbcc", 3));
    }
}
