package Solutions.TwoPointers.L986_IntervalListIntersections;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int len1 = firstList.length;
        int len2 = secondList.length;
        List<int[]> tans = new ArrayList<>();
        for (int i = 0, j = 0; i < len1 && j < len2;) {
            int []v1 = firstList[i];
            int []v2 = secondList[j];
            int start = Math.max(v1[0], v2[0]);
            int end = Math.min(v1[1], v2[1]);
            if (start <= end) {
                tans.add(new int[]{start, end});
            }
            if (v1[0] > v2[1] || v1[1] > v2[1] ) {
                j++;
            } else {
                i++;
            }
        }
        int [][] ans = new int[tans.size()][2];
        tans.toArray(ans);
        return ans;
    }
}
