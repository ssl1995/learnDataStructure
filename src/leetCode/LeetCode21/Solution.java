package leetCode.LeetCode21;

import leetCode.LeetCode142.ListNode;

public class Solution {
    // 递归法：深刻学习
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 递归结束条件
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 递归判断，每一次都返回最小值结点进递归栈
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    // 迭代法:preHead.next返回结果，pre用于调整较小值
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            // 最后要移动pre
            pre = pre.next;
        }
        pre.next = (l1 == null) ? l2 : l1;
        return preHead.next;
    }

}
