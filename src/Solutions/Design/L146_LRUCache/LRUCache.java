package Solutions.Design.L146_LRUCache;

import java.util.*;

class MyLinkedListNode {
    int val;
    int key;
    MyLinkedListNode pre;
    MyLinkedListNode next;

    public MyLinkedListNode(int key, int val) {
        this.val = val;
        this.key = key;
    }
}

public class LRUCache {
    private MyLinkedListNode tail;
    private MyLinkedListNode head;
    private Map<Integer, MyLinkedListNode> map;
    private Integer size;

    public LRUCache(int size) {
        this.size = size;
        tail = new MyLinkedListNode(-1, -1);
        head = new MyLinkedListNode(-1, -1);
        tail.pre = head;
        head.next = tail;
        map = new HashMap<>();
    }

    private void addNode (MyLinkedListNode node) {
        if (node != null) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }
    }


    private void removeNode (MyLinkedListNode node) {
        if (node != null) {
            MyLinkedListNode pre = node.pre;
            MyLinkedListNode next = node.next;
            pre.next = next;
            next.pre = pre;
        }
    }

    private void moveToHead (MyLinkedListNode node) {
        removeNode(node);
        addNode(node);
    }

    public int get(int key) {
        MyLinkedListNode node = map.get(key);
        if (node != null) {
            moveToHead(node);
        }
        return node == null ? -1 : node.val;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() == this.size) {
                map.remove(tail.pre.key);
                removeNode(tail.pre);
            }
            MyLinkedListNode node = new MyLinkedListNode(key, value);
            map.put(key, node);
            addNode(node);
        } else {
            MyLinkedListNode node = map.get(key);
            node.val = value;
            node.key = key;
            moveToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(10);
        var op = new String[]{"put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"};
        var data = new int[][]{{10,13},{3,17},{6,11},{10,5},{9,10},{13},{2,19},{2},{3},{5,25},{8},{9,22},{5,5},{1,30},{11},{9,12},{7},{5},{8},{9},{4,30},{9,3},{9},{10},{10},{6,14},{3,1},{3},{10,11},{8},{2,14},{1},{5},{4},{11,4},{12,24},{5,18},{13},{7,23},{8},{12},{3,27},{2,12},{5},{2,9},{13,4},{8,18},{1,7},{6},{9,29},{8,21},{5},{6,30},{1,12},{10},{4,15},{7,22},{11,26},{8,17},{9,29},{5},{3,4},{11,30},{12},{4,29},{3},{9},{6},{3,4},{1},{10},{3,29},{10,28},{1,20},{11,13},{3},{3,12},{3,8},{10,9},{3,26},{8},{7},{5},{13,17},{2,27},{11,15},{12},{9,19},{2,15},{3,16},{1},{12,17},{9,1},{6,19},{4},{5},{5},{8,1},{11,7},{5,2},{9,28},{1},{2,2},{7,4},{4,22},{7,24},{9,26},{13,28},{11,26}};
        for (int i = 0; i < op.length; i++) {
            if (op[i].equals("put")) {
                cache.put(data[i][0], data[i][1]);
                System.out.println("cache.put(" + data[i][0] + "," + data[i][1] + ");");
            } else if (op[i].equals("get")) {
                System.out.println(cache.get(data[i][0]));
            }
        }
    }
}
