package 剑指Offer.链表.剑指Offer18_删除链表结点;

import leetCode.Utils.ListNode;

public class Solution {


    public ListNode deleteNode(ListNode head, int val) {
        // 1.特殊判断head.val==val
        if (head.val == val) {
            return head.next;
        }
        // 2.初始化pre和cur
        ListNode pre = head;
        ListNode cur = head.next;
        // 3.cur遍历直到cur.val==val结点
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) {
            // 4.执行删除结点
            pre.next = cur.next;
        }
        return head;
    }
}
