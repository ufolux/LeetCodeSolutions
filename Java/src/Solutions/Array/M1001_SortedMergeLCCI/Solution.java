package Solutions.Array.M1001_SortedMergeLCCI;

class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int j = m - 1, k = n - 1;
        int cur = m + n - 1;
        while (k >= 0) {
            A[cur--] = (j >= 0 && B[k] < A[j]) ? A[j--] : B[k--];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}
