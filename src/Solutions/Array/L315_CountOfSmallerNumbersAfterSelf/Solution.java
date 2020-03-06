package Solutions.Array.L315_CountOfSmallerNumbersAfterSelf;

import java.util.Arrays;
import java.util.List;

public class Solution {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        int lcount;
    }

    TreeNode insertNode(TreeNode root, int val, Integer[] res, int resIndex) {
        if (root == null) {
            root = new TreeNode();
            root.val = val;
        } else if (val <= root.val) {
            root.lcount += 1;
            root.left = insertNode(root.left, val, res, resIndex);
        } else if (val > root.val) {
            res[resIndex] += root.lcount + 1;
            root.right = insertNode(root.right, val, res, resIndex);
        }
        return root;
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        Arrays.fill(res, 0);
        TreeNode root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insertNode(root, nums[i], res, i);
        }

        return Arrays.asList(res);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.countSmaller(new int[]{5,2,6,2,3,2,2,2,1});
    }
}
