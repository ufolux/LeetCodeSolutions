package Solutions.BST.L99_RecoverBinarySearchTree;

import com.sun.source.tree.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode pre, t1, t2;
    private void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        if (pre != null && pre.val > root.val) {
            if (t1 == null) t1 = pre;
            t2 = root;
        }
        pre = root;
        inOrder(root.right);
    }
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int tmp = t1.val;
        t1.val = t2.val;
        t2.val = tmp;
    }

    public static void main(String[] args) {

    }
}
