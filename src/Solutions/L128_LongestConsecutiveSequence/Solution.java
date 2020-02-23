package Solutions.L128_LongestConsecutiveSequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    /**
     * 时间复杂度 O(nlogn)
     * @param nums
     * @return
     */
    public int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int preLength = 0, postLength = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                postLength++;
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                preLength = Math.max(postLength, preLength);
                postLength = 0;
            }
        }
        return Math.max(postLength, preLength) + 1;
    }

    /**
     * O(nlogn)
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num: nums) {
            set.add(num);
        }

        int longestL = 0;
        for (int num: set) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curL = 1;
                while (set.contains(++curNum)) {
                    curL++;
                }
                longestL = Math.max(curL, longestL);
            }
        }
        return longestL;
    }

    /**
     * O(n)
     * @param nums
     * @return
     */
    public int longestConsecutive3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxL = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int curL = 1 + left + right;

                if (curL > maxL)
                    maxL = curL;

                map.put(num, curL);
                map.put(num - left, curL);
                map.put(num + right, curL);
            }
        }
        return maxL;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.longestConsecutive3(new int[]{1, 2, 0, 1});
    }
}
