package Solutions.DFS.L99_RecoverBinarySearchTree;

import BasicAlgos.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    void swap(TreeNode node1, TreeNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    public void recoverTree(TreeNode root) {
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.removeLast();
            if (prev != null && cur.val < prev.val) {
                second = cur;
                if (first == null) first = prev;
                else break;
            }
            prev = cur;
            cur = cur.right;
        }
        swap(first, second);
    }
}
