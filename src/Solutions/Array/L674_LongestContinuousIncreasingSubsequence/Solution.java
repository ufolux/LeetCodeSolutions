package Solutions.Array.L674_LongestContinuousIncreasingSubsequence;

class Solution {
    public int findLengthOfLCIS1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int end = 1;
        int maxLen = 1;
        while (end < nums.length) {
            int len = 1;
            if (nums[end] <= nums[end - 1]) {
                end++;
                continue;
            }
            while (end < nums.length && nums[end] > nums[end - 1]) {
                len++;
                end++;
            }
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }

    public int findLengthOfLCIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length < 2) return 1;
        int len = 1;
        int t = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                t++;
                if (t > len) {
                    len = t;
                }
            } else {
                t = 1;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findLengthOfLCIS1(new int[]{1, 3, 5, 4, 7});
        s.findLengthOfLCIS2(new int[]{1, 3, 5, 4, 7});
    }
}
