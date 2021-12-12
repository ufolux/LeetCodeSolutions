package Solutions.DFS.L100_SameTree;

import BasicAlgos.datastructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> st1 = new LinkedList<>();
        Deque<TreeNode> st2 = new LinkedList<>();
        while ((p != null && q != null) || (!st1.isEmpty() && !st2.isEmpty())) {
            while (p != null && q != null) {
                st1.add(p);
                st2.add(q);
                p = p.left;
                q = q.left;
            }
            if (p != null || q != null) {
                return false;
            }
            p = st1.removeLast();
            q = st2.removeLast();
            if (p.val != q.val) return false;
            p = p.right;
            q = q.right;
        }
        if ((p != null || q != null) || !(st1.isEmpty() && st2.isEmpty())) {
            return false;
        }
        return true;
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
    }
}