package codingGuide.第0章_牛客算法课.初级班.课5_二叉树;

import 第3章_二叉树问题.前中后序遍历.力扣.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDepth {
    // 递归法DFS
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            // 1.先记录出队元素的个数=当前层的队列的长度
            int len = queue.size();
            while (len > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                len--;
            }
            depth++;
        }
        return depth;
    }

}
