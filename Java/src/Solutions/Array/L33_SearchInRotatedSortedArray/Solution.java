package Solutions.Array.L33_SearchInRotatedSortedArray;

import java.util.Arrays;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l + 1) / 2;
            if (nums[mid] == target) return mid;
            if (nums[l] <= nums[mid]) { // 左半部分有序
                if (nums[mid] > target && nums[l] <= target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else { // 右半部分有序
                if (nums[mid] < target && nums[r] >= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.search(new int[]{1,3}, 2);
    }
}
