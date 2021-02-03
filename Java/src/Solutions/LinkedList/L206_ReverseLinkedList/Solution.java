package Solutions.LinkedList.L206_ReverseLinkedList;

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode iterationReverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;
        }
        return prev;
    }

    public ListNode reverse(ListNode prev, ListNode curr) {
        if (curr != null) {
            ListNode t = curr.next;
            curr.next = prev;
            return reverse(curr, t);
        }
        return prev;
    }

    public ListNode recursionReverseList(ListNode head) {
        return reverse(null, head);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head = new ListNode(0);
        ListNode next = head;
        for (int i = 0; i < 5; i++) {
            next.next =  new ListNode(i + 1);
            next = next.next;
        }
        s.iterationReverseList(head);

        head = new ListNode(0);
        next = head;
        for (int i = 0; i < 5; i++) {
            next.next =  new ListNode(i + 1);
            next = next.next;
        }
        s.recursionReverseList(head);
    }
}
