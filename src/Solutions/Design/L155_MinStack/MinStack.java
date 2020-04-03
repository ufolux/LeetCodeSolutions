package Solutions.Design.L155_MinStack;

import java.util.Stack;

class ListNode {
    int val;
    int min;
    ListNode next;
    ListNode (int val, int min) {
        this.val = val;
        this.min = min;
    }
}

public class MinStack {
    ListNode dummyHead;
    /** initialize your data structure here. */
    public MinStack() {
        dummyHead = new ListNode(Integer.MAX_VALUE,Integer.MAX_VALUE);
    }

    public void push(int x) {
        int min = dummyHead.next != null && x > dummyHead.next.min ? dummyHead.next.min : x;
        ListNode node = new ListNode(x, min);
        node.next = dummyHead.next;
        dummyHead.next = node;
    }

    public void pop() {
        ListNode node = dummyHead.next;
        dummyHead.next = dummyHead.next.next;
        node.next = null;
    }

    public int top() {
        return dummyHead.next.val;
    }

    public int getMin() {
        return dummyHead.next.min;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        stack.getMin();
        stack.pop();
        stack.top();
        stack.getMin();
    }
}
