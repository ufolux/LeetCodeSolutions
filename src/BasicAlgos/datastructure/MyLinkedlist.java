package BasicAlgos.datastructure;

// Linklist Node
class Node {
    public int val;
    public Node next;
}

public class MyLinkedlist {
    int size = 100;
    Node head;

    MyLinkedlist() {
        int i = 0;
        head = new Node();
        Node next = head;
        while (i < size) {
            next.val = i;
            if (i != size - 1) {
                next.next = new Node();
                next = next.next;
            }
            i++;
        }
    }

    /**
     * Traverse a linklist
     */
    void traverse() {
        Node next = head;
        while (next != null) {
            System.out.print(next.val + "-->");
            next = next.next;
        }
        System.out.println("Traverse End");
    }

    /**
     * Delete node at index and return new head
     * @param index
     * @return
     */
    Node deleteNode (int index) {
        if (index >= size || index < 0) {
            return null;
        }
        int i = 0;
        Node removeNode = head;
        Node next = head;
        if (index == 0) {
            removeNode = next;
            head = removeNode.next;
            removeNode.next = null;
            size--;
            return removeNode;
        }
        while (index - 1 != i) {
            next = next.next;
            i++;
        }
        Node targetNode = next.next;
        removeNode = targetNode;
        next.next = next.next.next;
        targetNode.next = null;
        size--;
        return removeNode;
    }

    void insertNode (Node newNode, int index) {
        if (index < 0 || index > size) {
            return;
        }
        int i = 0;
        Node next = head;
        if (index == 0) {
            newNode.next = next;
            return;
        }
        while (i != index - 1) {
            next = next.next;
            i++;
        }
        newNode.next = next.next;
        next.next = newNode;
        size++;
    }

    public static void main(String[] args) {
        MyLinkedlist list = new MyLinkedlist();
        list.traverse();

        // delete head mid and last
        list = new MyLinkedlist();
        list.deleteNode(0);
        list.traverse();
        list = new MyLinkedlist();
        list.deleteNode(10);
        list.traverse();
        list = new MyLinkedlist();
        list.deleteNode(99);
        list.traverse();

        // insert head mid and last
        Node newNode = new Node();
        newNode.val = 12;
        list = new MyLinkedlist();
        list.insertNode(newNode, 0);
        list.traverse();
        list = new MyLinkedlist();
        list.insertNode(newNode, 10);
        list.traverse();
        list = new MyLinkedlist();
        list.insertNode(newNode, 100);
        list.traverse();
    }
}
