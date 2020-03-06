package Solutions.LinkedList.L2_AddTwoNumbers;

import java.util.LinkedList;
import java.util.Queue;

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0), cur = root;
        int carray = 0;
        while (l1 != null || l2 != null || carray!= 0) {
            int l1V = l1 != null ? l1.val : 0;
            int l2V = l2 != null ? l2.val : 0;

            int digit = (l1V + l2V + carray) % 10;
            carray = (l1V + l2V + carray) / 10;
            cur.next = new ListNode(digit);

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.addTwoNumbers(new ListNode(5), new ListNode(5));
    }
}
