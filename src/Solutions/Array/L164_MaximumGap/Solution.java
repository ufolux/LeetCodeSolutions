package Solutions.Array.L164_MaximumGap;

import java.util.Arrays;

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int n = nums.length;
        int max = nums[0], min = nums[0];
        for (int num: nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        if (max - min == 0) {
            return 0;
        }

        int[] bucketMax = new int[n - 1];
        int[] bucketMin = new int[n - 1];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);

        int interval = (int)Math.ceil((double)(max - min) / (n -  1));

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num == min || num == max) {
                continue;
            }
            int idx =  (nums[i] - min)/ interval;
            bucketMax[idx] = Math.max(bucketMax[idx], num);
            bucketMin[idx] = Math.min(bucketMin[idx], num);
        }

        int maxGap = 0;
        int preMax = min;
        for (int i = 0; i < n - 1; i++) {
            if (bucketMax[i] == Integer.MIN_VALUE) {
                continue;
            }
            maxGap = Math.max(bucketMin[i] - preMax, maxGap);
            preMax = bucketMax[i];
        }
        maxGap = Math.max(max - preMax, maxGap);

        return maxGap;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,1,1,1,1,5,5,5,5,5};
        s.maximumGap(nums);
        System.out.print(Arrays.toString(nums));
    }
}
