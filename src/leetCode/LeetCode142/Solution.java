package leetCode.LeetCode142;

// 环形链表2：返回入环的第一个结点
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        // 1.使快慢指针第一次相遇
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        // 2.如果相遇，快指针必须重新指向head
        fast = head;
        // 3.规律：第二次相遇的时候，一定在第一个入环的节点处
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
