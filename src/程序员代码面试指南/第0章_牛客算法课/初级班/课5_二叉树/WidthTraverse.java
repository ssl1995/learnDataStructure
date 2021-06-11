package 程序员代码面试指南.第0章_牛客算法课.初级班.课5_二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class WidthTraverse {
    // 二叉树宽度遍历=层次遍历
    public static void widthTraverse(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.println(head.value + " ");
            if (head.left != null) {
                queue.offer(head.left);
            }
            if (head.right != null) {
                queue.offer(head.right);
            }
        }
        System.out.println();
    }
}
