package Solutions.Tree.L103_BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }
    void dfs (TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (level == res.size()) res.add(new ArrayList<Integer>());
        if ((level & 1) == 1) res.get(level).add(0, root.val);
        else res.get(level).add(root.val);
        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
    }
}
