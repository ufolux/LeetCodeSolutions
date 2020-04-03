package Solutions.LinkedList.L148_SortList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    /**
     * 双路归并
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null) return head;
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode node) {
        if (node.next == null) return node;
        ListNode s = node, f = node, pre = null;
        // find middle of the list
        while (s != null && f != null && f.next != null) {
            pre = s;
            s = s.next;
            f = f.next.next;
        }
        // cut list
        pre.next = null;
        ListNode preList = mergeSort(node);
        ListNode sufList = mergeSort(s);
        return merge(preList, sufList);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1), cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
            cur.next = null;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return dummyHead.next;
    }

    void printList (ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int i = 10;
        while (i-- > 0) {
            cur.next = new ListNode((int)(Math.random() * 100));
            cur = cur.next;
        }
        s.printList(head);
        s.sortList(head);
        s.printList(head);
    }
}
