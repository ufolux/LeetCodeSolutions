package Solutions.Array.L53_MaximumSubarray;

public class Solution {
    /**
     * greedy algorithm
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int sum = 0;
        int res = nums[0];
        for (int n: nums) {
            sum += n;
            res = Math.max(res, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxSubArray1(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        s.maxSubArray1(new int[]{-2,-1});
    }
}
