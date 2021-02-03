package Solutions.Array.L56_MergeIntervals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    /**
     * 最差方案
     * @param intervals
     * @return
     */
    public int[][] merge1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        for (int[] ele : intervals) {
            ans.add(ele);
        }
        for (int i = 1; i < ans.size(); i++) {
            if (ans.get(i - 1)[1] >= ans.get(i)[1]) {
                ans.remove(ans.get(i));
                i--;
            } else if (ans.get(i - 1)[1] >= ans.get(i)[0]) {
                ans.set(i - 1, new int[]{ans.get(i - 1)[0], ans.get(i)[1]});
                ans.remove(ans.get(i));
                i--;
            }
        }
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.merge1(new int[][]{
                {2, 6}, {1, 3}, {8, 10}, {15, 18}
        });
        s.merge1(new int[][]{
                {1, 4}, {4, 5}
        });
    }
}
