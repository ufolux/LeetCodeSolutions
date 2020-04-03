package Solutions.Tree.L236_LowestCommonAncestorOfABinaryTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 根节点为空说明遍历到了叶子结点依然没有找到pq，直接返回上一层
        if (root == null) return root;
        // 找到了pq节点，将结果返回
        if (root == p || root == q) return root;
        // 还没找到pq，继续向下寻找
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 在左边和右边找到了pq，将root返回到上一层
        if (left != null && right != null) return root;
        // 在左边或右边找到了pq 的LCA，将结果返回上一层
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}
