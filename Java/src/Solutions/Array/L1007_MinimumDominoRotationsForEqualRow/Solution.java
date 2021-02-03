package Solutions.Array.L1007_MinimumDominoRotationsForEqualRow;

public class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int[] cntArr = new int[7];
        // count the most elements
        for (int i = 0; i < A.length; i++) {
            cntArr[A[i]]++;
            cntArr[B[i]]++;
        }
        // find the most elements
        int max = 0, maxP = 0;
        for (int i = 0; i < 7; i++) {
            if (cntArr[i] > max) {
                max = cntArr[i];
                maxP = i;
            }
        }

        // if max < A.length or B.length, it is impossible to get a result
        if (max < A.length) return -1;

        int counterA = 0, counterB = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != maxP)
                if (B[i] == maxP)
                    counterA++;
                else return -1;
            if (B[i] != maxP)
                if (A[i] == maxP)
                    counterB++;
                else
                    return -1;
        }

        return counterA < counterB ? counterA : counterB;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.minDominoRotations(
                new int[]{2, 1, 2, 4, 2, 2},
                new int[]{5, 2, 6, 2, 3, 2}
        );
        System.out.print(res);
    }
}
