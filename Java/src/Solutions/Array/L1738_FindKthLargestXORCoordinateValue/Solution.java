package Solutions.Array.L1738_FindKthLargestXORCoordinateValue;

import java.util.Arrays;

public class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m*n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != 0) matrix[i][j] ^= matrix[i-1][j];
                if (j != 0) matrix[i][j] ^= matrix[i][j-1];
                if (i != 0 && j != 0) matrix[i][j] ^= matrix[i-1][j-1];
                res[i * n + j] = matrix[i][j];
            }
        }
        Arrays.sort(res);
        return res[m * n - k];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.kthLargestValue(new int[][]{{10,9,5},{2,0,4},{1,0,9},{3,4,8}}, 1);
        System.out.println(res);
    }
}
