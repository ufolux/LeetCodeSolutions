package Solutions.LinkedList.L369_PlusOneLinkedList;

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        // reverse
        while(cur != null){
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }

        // plus one

        ListNode newHead = pre;
        cur = newHead;
        int one = 1;
        while (cur != null) {
            if (cur.val + 1 < 10) {
                cur.val += 1;
                break;
            } else {
                cur.val = (cur.val + 1) % 10;
            }
            if (cur.next == null && one == 1) {
                cur.next = new ListNode(1);
                one = 0;
                break;
            }
            cur = cur.next;
        }

        // reverse
        cur = newHead;
        pre = null;
        while(cur != null){
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        ListNode next = head;
        for (int i = 0; i < 2; i++) {
            next.next =  new ListNode(9);
            next = next.next;
        }
        Solution s = new Solution();
        s.plusOne(head);
    }
}
