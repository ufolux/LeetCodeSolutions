package CasualAlgos;

import java.util.LinkedList;
import java.util.Queue;

public class UseTwoQueueSimStack {
    private Queue<Integer> qStack = new LinkedList();
    private Queue<Integer> helper = new LinkedList();
    public void push(Integer ele) {
        while(!qStack.isEmpty()) {
            helper.add(qStack.poll());
        }
        qStack.add(ele);
        while (!helper.isEmpty()) {
            qStack.add(helper.poll());
        }
    }

    public Integer pop() {
        if (!qStack.isEmpty()) {
            return qStack.poll();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        UseTwoQueueSimStack stack = new UseTwoQueueSimStack();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }
    }
}
