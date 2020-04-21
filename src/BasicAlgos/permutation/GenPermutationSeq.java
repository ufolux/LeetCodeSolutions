package BasicAlgos.permutation;

import java.util.*;

public class GenPermutationSeq {
    /**
     * 递归法全排列
     * Non Lexicographical Order
     * @param nums
     * @return
     */
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        genPermute1(res, nums, 0);
        return res;
    }

    public void genPermute1(List<List<Integer>> res, int[] nums, int start) {
        if (start == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int i: nums) {
                list.add(i);
            }
            res.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i); // swap
            genPermute1(res, nums, start + 1); // permute start + 1 to arr.length;
            swap(nums, start, i); // recovery
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    /**
     * 回溯法
     * Lexicographical Order
     * @param nums
     * @return
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backTrack(res, nums, new ArrayList<>(), visited);
        return res;
    }

    public void backTrack (List<List<Integer>> res, int[] nums, List<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            backTrack(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }


    public static void main(String[] args) {
        GenPermutationSeq s = new GenPermutationSeq();
        s.permute1(new int[]{1,2,3,4,5});
        s.permute2(new int[]{1,2,3,4,5});
    }
}
