package Solutions.MonoStack.L85_MaximalRectangle;

import java.util.Arrays;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        if (r == 0) return 0;
        int c = matrix[0].length;
        int[] h = new int[c];
        int[] maxArr = new int[r];
        Solutions.MonoStack.L84_LargestRectangleinHistogram.Solution s = new Solutions.MonoStack.L84_LargestRectangleinHistogram.Solution();
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (i == 0) {
                    h[j] = matrix[i][j] - '0';
                } else {
                    h[j] = matrix[i][j] == '0' ? 0 : h[j] + 1;
                }
            }
            maxArr[i] = s.largestRectangleArea(h);
        }
        Arrays.sort(maxArr);
        return maxArr[maxArr.length - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.maximalRectangle(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        });
        System.out.println(res);
    }
}
