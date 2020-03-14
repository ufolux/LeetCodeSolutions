package Solutions.Array.L300_LongestlncreasingSubsequence;

import java.util.Arrays;

public class Solution {
    /**
     * O(nlogn)
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        /**
         dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
         由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
         对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
         1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
         数组尾部, 并将最长递增序列长度maxL加1
         2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
         **/
        int maxL = 0;
        int[] dp = new int[nums.length];
        for(int num : nums) {
            // 二分法查找, 也可以调用库函数如binary_search
            int lo = 0, hi = maxL;
            while(lo < hi) {
                int mid = lo+(hi-lo)/2;
                if(dp[mid] < num)
                    lo = mid+1;
                else
                    hi = mid;
            }
            dp[lo] = num;
            if(lo == maxL)
                maxL++;
        }
        return maxL;
    }

    /**
     * O(n^2)
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length < 2) return 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int n: dp)
            max = Math.max(max, n);

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.lengthOfLIS1(new int[]{1,2,5,3,4,6,7,5,6,9,29,322,32,424});
        s.lengthOfLIS2(new int[]{1,2,5,3,4,6,7,5,6,9,29,322,32,424});
    }
}
