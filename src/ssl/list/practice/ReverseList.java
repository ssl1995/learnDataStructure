package ssl.list.practice;


import ssl.utils.ListNode;

/**
 * @Author ssl
 * @Date 2020/12/10 17:15
 * @Description
 */
public class ReverseList {
    // 非递归方法
    public static ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        // 遍历指针
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 由于cur遍历到末尾.next，所以返回pre
        return pre;
    }

    // 递归实现
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseList2(head.next);
        // 递归反转
        head.next.next = head;
        head.next = null;
        return cur;
    }


}
