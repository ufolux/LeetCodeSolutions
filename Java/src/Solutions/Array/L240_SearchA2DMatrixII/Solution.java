package Solutions.Array.L240_SearchA2DMatrixII;

public class Solution {
    /**
     * 减治法，缩小问题规模
     * 先定位到左下角的元素 ele，这个元素小于最后一行的其他元素，大于第一列其他元素
     * 1. target < ele 则 ele 小于最后一行所有元素 -> i--
     * 2. target == ele 找到，返回 true
     * 3. target > ele 则 ele 大于第一列所有元素 -> j++
     * 如果最后子问题集合为空数组，那么没找到，返回 false
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = m - 1, j = 0; i >= 0 && j < n; ) {
            if (target < matrix[i][j]) {
                i--;
            } else if (target == matrix[i][j]) {
                return true;
            } else {
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.searchMatrix(
                new int[][]{
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
                }, 5);
    }
}
