package Solutions.Array.L287_FindTheDuplicateNumber;

/**
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class Solution {
    /**
     * 快慢指针
     * T: O(n)
     * S: O(1)
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) {
                fast = 0;
                while (slow != fast) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }

    /**
     * 二分查找
     * T: O(NlogN)
     * S: O(1)
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        int n = nums.length;
        int left = 1, right = n - 1;
        while (left < right) {
            int cnt = 0;
            int mid = (left + right + 1) >>> 1;
            for (int num: nums) {
                if (num < mid) cnt++;
            }
            if (cnt >= mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findDuplicate1(new int[]{5, 4, 3, 1, 3, 2});
        s.findDuplicate2(new int[]{5, 4, 3, 1, 3, 2});
    }
}
