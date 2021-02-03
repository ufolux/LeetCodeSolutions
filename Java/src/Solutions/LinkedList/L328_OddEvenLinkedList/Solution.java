package Solutions.LinkedList.L328_OddEvenLinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head = new ListNode(0);
        ListNode next = head;
        for (int i = 0; i < 5; i++) {
            next.next =  new ListNode(i + 1);
            next = next.next;
        }
        s.oddEvenList(head);
    }
}
