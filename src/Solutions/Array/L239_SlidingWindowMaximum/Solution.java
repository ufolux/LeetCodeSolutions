package Solutions.Array.L239_SlidingWindowMaximum;

//Given an array nums, there is a sliding window of size k which is moving from
//the very left of the array to the very right. You can only see the k numbers in
//the window. Each time the sliding window moves right by one position. Return the
// max sliding window.
//
// Follow up:
//Could you solve it in linear time?
//
// Example:
//
//
//Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//Output: [3,3,5,5,6,7]
//Explanation:
//
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4
// 1 <= k <= nums.length
//
// Related Topics 堆 Sliding Window


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    /**
     * worst solution
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return new int[]{};

        int[] res = new int[nums.length - k + 1];
        int b = 0, e = k - 1;
        while (e < nums.length) {
            int max = Integer.MIN_VALUE;
            for (int i = b; i <= e; i++) {
                max = Math.max(max, nums[i]);
            }
            res[b] = max;
            b++;
            e++;
        }
        return res;
    }

    /**
     * cut branch
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return new int[]{};
        int[] res = new int[nums.length - k + 1];
        int b = 0, e = k - 1;
        int max = Integer.MIN_VALUE;
        for (;e < nums.length; b++, e++) {
            if (b > 0 && nums[b - 1] == max && nums[e] == max) {
                res[b] = max;
            } else if (b > 0 && nums[b - 1] == max && nums[e] < max) {
                max = Integer.MIN_VALUE;
                for (int i = b; i <= e; i++) {
                    max = Math.max(max, nums[i]);
                }
            } else if (b > 0 && nums[b - 1] == max && nums[e] < max) {
                max = nums[e];
            }
//          else if (nums[b - 1] != max) {
//              max = max;
//          }
            res[b] = max;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] res1 = s.maxSlidingWindow1(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        int[] res2 = s.maxSlidingWindow2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

