package Solutions.Array.L15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) return res;
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1, R = len - 1;
            int sum = 0;
            while (L < R) {
                sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    List<Integer> list = Arrays.asList(nums[i], nums[L], nums[R]);
                    res.add(list);
                    // 去重
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++; R--;
                }

                if (sum < 0) L++;
                if (sum > 0) R--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}
