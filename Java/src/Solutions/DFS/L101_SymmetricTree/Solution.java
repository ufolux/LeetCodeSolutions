package Solutions.DFS.L101_SymmetricTree;

import BasicAlgos.datastructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    boolean dfs(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;
        if (r1.val != r2.val) return false;
        return dfs(r1.left, r2.right) && dfs(r1.right, r2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    public boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> dq1 = new LinkedList<>();
        Deque<TreeNode> dq2 = new LinkedList<>();
        TreeNode r1 = root.left, r2 = root.right;
        while ((r1 != null && r2 != null) || (!dq1.isEmpty() && !dq2.isEmpty())) {
            while (r1 != null && r2 != null) {
                dq1.push(r1);
                dq2.push(r2);
                r1 = r1.left;
                r2 = r2.right;
            }
            if (r1 != null || r2 != null) return false;
            r1 = dq1.removeLast();
            r2 = dq2.removeLast();
            if (r1.val != r2.val) return false;
            r1 = r1.right;
            r2 = r2.left;
        }
        if ((r1 != null || r2 != null) || !(dq1.isEmpty() && dq2.isEmpty())) return false;
        return true;
    }
}
