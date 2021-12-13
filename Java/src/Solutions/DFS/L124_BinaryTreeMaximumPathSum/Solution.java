package Solutions.DFS.L124_BinaryTreeMaximumPathSum;

import BasicAlgos.datastructure.TreeNode;

public class Solution {
    int maxPrice = Integer.MIN_VALUE;
    int gainMax(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(gainMax(root.left), 0);
        int right = Math.max(gainMax(root.right), 0);
        int maxPathPrice = root.val + right + left;
        maxPrice = Math.max(maxPathPrice, maxPrice);
        return root.val + Math.max(left, right);
    }
    public int maxPathSum(TreeNode root) {
        gainMax(root);
        return maxPrice;
    }
}
