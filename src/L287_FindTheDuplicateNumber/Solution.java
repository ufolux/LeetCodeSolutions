package L287_FindTheDuplicateNumber;

public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2 ) {
            return 0;
        }
        int temp = 0;
        for (int i = 0; i < nums.length;) {
            int n = nums[i];
            if (n != i) {
                if (nums[n] == n) {
                    return n;
                } else {
                    i = nums[n];
                    nums[n] = n;
                }
            } else {
                i++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findDuplicate(new int[]{3,1,3,4,2});
    }
}
