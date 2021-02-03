package Solutions.LinkedList.L23_MergeKSortedLists;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    /**
     * 归并算法 O(NlogN)
     * @param lists
     * @return
     */
    public ListNode mergeKLists (ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeKLists(0, lists.length - 1, lists);
    }

    private ListNode mergeKLists (int l, int r, ListNode[] lists) {
        if (l == r) return lists[l];
        if (l + 1 == r) return mergeTwoLists(lists[l], lists[r]);
        int mid = l + (r - l) / 2;
        return mergeTwoLists(mergeKLists(l, mid, lists), mergeKLists(mid + 1, r, lists));
    }

    public ListNode mergeTwoLists (ListNode a, ListNode b) {
        ListNode dummyHead = new ListNode(-1), cur = dummyHead;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
                cur = cur.next;
                cur.next = null;
            } else {
                cur.next = b;
                b = b.next;
                cur = cur.next;
                cur.next = null;
            }
        }
        if (a != null) cur.next = a;
        if (b != null) cur.next = b;
        return dummyHead.next;
    }
}