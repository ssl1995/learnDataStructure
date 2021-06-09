package codingInterview.栈与队列.剑指Offer06_从尾到头打印链表;

import leetCode.Utils.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    // 方法1:递归法,迭代返回后将val放入辅助链表中
    public int[] reversePrint1(ListNode head) {
        List<Integer> temp = new ArrayList<>();
        reverse(head, temp);
        int[] res = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        return res;
    }

    private void reverse(ListNode node, List temp) {
        if (node == null) {
            return;
        }
        reverse(node.next, temp);
        // 下一层递归结束,接受这一层的node.val
        temp.add(node.val);
    }

    // 法2:先入后出使用栈
    public int[] reversePrint(ListNode head) {
        // 栈推荐使用LinkedList,不要向上转型
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        // 遍历只能使用res.length,不能使用stack.size(),因为stack要removeLast
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeLast();
        }

        return res;
    }
}
