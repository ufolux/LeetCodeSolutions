package BasicAlgos.datastructure;
import java.util.Arrays;
import java.util.LinkedList;

enum Order {
    PRE,
    IN,
    POST
}

public class BiTree {
    private TreeNode root;
    /**
     * Build a bitree
     */
    BiTree () {
        LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null, null,8,null,4}));
        root = createBiTree(list);
    }

    private TreeNode createBiTree(LinkedList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        TreeNode node = null;
        Integer val = list.removeFirst();
        if (val != null) {
            node = new TreeNode();
            node.val = val;
            node.left = createBiTree(list);
            node.right = createBiTree(list);
        }
        return node;
    }

    private void traversePreOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.val + "-->");
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }


    private void traverseInOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        traversePreOrder(node.left);
        System.out.print(node.val + "-->");
        traversePreOrder(node.right);
    }


    private void traversePostOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        traversePreOrder(node.left);
        traversePreOrder(node.right);
        System.out.print(node.val + "-->");
    }

    public void traverse(Order order) {
        switch (order) {
            case PRE: {
                System.out.println("Pre Order");
                traversePreOrder(root);
                System.out.println("");
                break;
            }
            case IN:{
                System.out.println("In Order");
                traverseInOrder(root);
                System.out.println("");
                break;
            }
            case POST: {
                System.out.println("Post Order");
                traversePostOrder(root);
                System.out.println("");
                break;
            }
            default: {
                break;
            }
        }
    }

    public static void main(String[] args) {
        BiTree bt = new BiTree();

        bt.traverse(Order.PRE);
        bt.traverse(Order.IN);
        bt.traverse(Order.POST);
    }
}
