package Solutions.DFS.L98_ValidateBinarySearchTree;

import BasicAlgos.datastructure.TreeNode;

import java.util.Stack;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        Integer last = null;
        TreeNode cur = root;
        Stack<TreeNode> st = new Stack<>();
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            if (last != null && cur.val <= last) return false;
            last = cur.val;
            cur = cur.right;
        }
        return true;
    }
}
