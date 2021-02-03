package Solutions.Array.L16_3SumCloset;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int L = i + 1, R = nums.length - 1;
            while (L < R) {
                sum = nums[i] + nums[L] + nums[R];
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (sum < target) {
                    L++;
                } else if (sum > target) {
                    R--;
                } else {
                    return target;
                }
            }
        }
        return closest;
    }
}
