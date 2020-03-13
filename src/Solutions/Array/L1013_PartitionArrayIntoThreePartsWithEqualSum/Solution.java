package Solutions.Array.L1013_PartitionArrayIntoThreePartsWithEqualSum;

public class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        if (A == null || A.length == 0) return false;
        int sum = 0;
        for (int n: A) {
            sum += n;
        }
        if (sum % 3 != 0) return false;
        Integer unitSum = sum / 3;

        Integer l = 0, r = A.length - 1;
        Integer ls = null, rs = null;
        while (!ls.equals(unitSum) && l < A.length) {
            ls = ls == null ? 0 : ls;
            ls += A[l++];
        }

        while (!rs.equals(unitSum) && r >= 0) {
            rs = rs == null ? 0 : rs;
            rs += A[r--];
        }

        Integer mids = null;
        if (ls.equals(unitSum) && rs.equals(unitSum)) {
            while (l <= r) {
                mids = mids == null ? 0 : mids;
                mids += A[l++];
            }
        }
        if (mids.equals(unitSum)) return true;
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.canThreePartsEqualSum(new int[]{458,-78,22,-59,38,-81,453,-229,-281,562,-329,-268,579,-648,62,609,-134,-639,206,72,118,-344,106,642,-693,662,84,-609,255,-116,477,-741,-7,-136,794,9,-668,598,-720,39,-45,455,153,-559,408,347,-668,387,271,-214,-148,-344,754,-547,494,-55,-303,9,-23,368,-296,-194,496,-47,-111,102,73,-707,144,89,-353,423,22,373,-337,-54,-65,263,-594,133,382,61,194,-447,93,-363,447,-448,571,-633,230,67,56,-112,585,-252,-71,186,61,-246,-10,197,187});
    }
}
