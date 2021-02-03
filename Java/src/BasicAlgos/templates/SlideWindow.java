package BasicAlgos.templates;

import java.util.*;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 * 限制：
 * 1 <= target <= 10^5
 */
public class SlideWindow {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int l = 1, r = 1, sum = 0;
        while (l <= target / 2) {
            sum += r;
            while (sum > target) {
                sum -= l++;
            }

            if (sum == target) {
                int[] seq = new int[r - l + 1];
                for (int k = l; k <= r; k++) seq[k - l] = k;
                list.add(seq);
            }
            r++;
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        SlideWindow slideWindow = new SlideWindow();
        slideWindow.findContinuousSequence(9);
        slideWindow.findContinuousSequence(15);
    }
}
