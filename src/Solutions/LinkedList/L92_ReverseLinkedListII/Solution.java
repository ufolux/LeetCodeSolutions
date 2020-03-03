package Solutions.LinkedList.L92_ReverseLinkedListII;

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = null, cur = head, con = null, tail = null;
        while (m > 1) {
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }
        con = pre;
        tail = cur;

        ListNode temp = null;
        while (n > 0) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            n--;
        }

        tail.next = cur;
        if (con == null) head = pre;
        else con.next = pre;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode next = head;
        for (int i = 0; i < 2; i++) {
            next.next =  new ListNode(i + 1);
            next = next.next;
        }
        Solution s = new Solution();
        s.reverseBetween(head, 1, 2);
    }
}
