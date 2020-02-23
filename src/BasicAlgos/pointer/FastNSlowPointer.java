package BasicAlgos.pointer;

/**
 * 快慢指针
 * 用途，判断链表是否成环
 * https://blog.csdn.net/imzoer/article/details/8030297
 */
public class FastNSlowPointer {
    public int findIfLinklistHasCircle (int[] nums) {
        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(slow == fast) { // 此时，快慢指针第一次相遇，但相遇的位置不一定是环的入口
                /** 所以要继续找环的入口
                 * 此时，假设从起点到环的入口位置的距离为 p，环的起点到相遇点的距离为 c
                 * 慢指针走过的距离是 n 那么快指针走过的距离为 2n
                 * 所以：n = p + c
                 * 因为：快指针走到相遇点花了2n距离，而慢指针只花了n距离，所以慢指针再走n距离
                 * 也会再次回到相遇点
                 * 所以：慢指针此时距离入口的距离就是 n - c = p，这个距离也就是和起点到入口的距离相同
                 */
                fast = 0;
                // 让快指针回到起点
                while(fast != slow) {
                    // 快指针和慢指针一起走，直到相遇
                    // 这样快指针走过了和慢指针相同的距离，都是 p，他们这时也就同时到达了入口
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }

    public static void main(String[] args) {
        FastNSlowPointer s = new FastNSlowPointer();
        s.findIfLinklistHasCircle(new int[]{1,3,4,2,2});
    }
}
