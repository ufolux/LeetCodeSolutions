package Solutions.Backtracking.L47_PermutationsII;

import java.util.*;

public class Solution {
    /**
     * 剪枝 backtrack
     * @param nums
     * @return
     */
    List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        backtrack(res, nums, visited, new ArrayList<>());
        return res;
    }

    void backtrack(List<List<Integer>> res, int[] nums, int[] visited, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 1)) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, visited, tmp);
            tmp.remove(tmp.size() - 1);
            visited[i] = 0;
        }
    }

    /**
     * 剪枝 swap 最优解
     * @param nums
     * @return
     */
    List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        dfs(res, nums, 0);
        return res;
    }

    void dfs(List<List<Integer>> res, int[] nums, int cur) {
        if (cur == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i: nums) {
                list.add(i);
            }
            res.add(list);
        } else {
            for (int i = cur; i < nums.length; i++) {
                if (canSwap(nums, cur, i)) {
                    swap(nums, i, cur);
                    dfs(res, nums, cur + 1);
                    swap(nums, i, cur);
                }
            }
        }
    }

    boolean canSwap (int[] nums, int b, int e) {
        for (int i = b; i < e; i++) {
            if (nums[i] == nums[e]) return false;
        }
        return true;
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.permuteUnique1(new int[]{1,2,3,4,2,1,3});
        s.permuteUnique2(new int[]{1,2,3,4,2,1,3});
    }
}
