package leetCode.LeetCode21;

import leetCode.Utils.ListNode;

public class Solution {

    // 迭代法:preHead.next返回结果，pre用于调整较小值
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        // 设定一个哑结点,方便返回值
        ListNode dummyNode = new ListNode(-1);
        // cur指针指向每次比较的较小值结点
        ListNode cur = dummyNode;
        while (l1 != null && l2 != null) {
            // 判断较小值,cur指向它
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            // 判断完后移cur
            cur = cur.next;
        }
        // 循环结束,cur指向非空链表头部
        cur.next = (l1 == null) ? l2 : l1;
        return dummyNode.next;
    }

    // 递归法：判断 l1 和 l2 头结点哪个更小，然后较小结点的 next 指针指向其余结点的合并结果
    // 因为l1、l2有序,所以递归最后一定是指向一个最短有序链表的,然后递归依次返回
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 递归结束情况1:某个链表遍历到了末尾
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        // 递归判断，每一次都返回最小值结点进递归栈
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            // 递归结束条件2:返回某个链表的最小值结点
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            // 递归结束条件2:返回某个链表的最小值结点
            return l2;
        }
    }
}
