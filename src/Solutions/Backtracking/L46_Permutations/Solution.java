package Solutions.Backtracking.L46_Permutations;

import java.util.*;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(res, nums, visited, new ArrayList<>());
        return res;
    }

    public void backtrack(List<List<Integer>> res, int[] nums, int[] visited, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, visited, tmp);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.permute(new int[]{1, 2, 3, 4, 5});
    }
}
