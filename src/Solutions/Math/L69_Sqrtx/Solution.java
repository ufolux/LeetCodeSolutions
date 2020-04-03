package Solutions.Math.L69_Sqrtx;

public class Solution {
    public int mySqrt(int x) {
        int sum = 0;
        double l = 1, r = x;
        while (l <= r) {
            double mid = l + (r - l) / 2;
            double prod = mid * mid;
            double diff = prod - x;
            if (diff < 1 && diff >= 0) {
                return (int)mid;
            } else if (diff >= 1) {
                r = mid;
            } else if (diff < 0) {
                l = mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.mySqrt(100);
    }
}
