package Solutions.Tree.L337_HouseRobberIII;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

public class Solution {
    private Map<TreeNode, Integer> m = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (m.containsKey(root)) {
            return m.get(root);
        }
        int ll = root.left != null ? rob(root.left.left) : 0;
        int lr = root.left != null ? rob(root.left.right) : 0;
        int rl = root.right != null ? rob(root.right.left) : 0;
        int rr = root.right != null ? rob(root.right.right) : 0;
        m.put(root, Math.max(root.val + ll + lr + rl + rr, rob(root.left) + rob(root.right)));
        return m.get(root);
    }
}
