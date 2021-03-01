package LeetCode.LeetCode104;

import java.util.LinkedList;

public class Solution {
    // 递归法
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = maxDepth1(root.left);
        int rh = maxDepth1(root.right);
        return Math.max(lh, rh) + 1;
    }

    // DFS法
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 队列存每一层的结点个数
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;
        while (!queue.isEmpty()) {
            // 队列非空，先获得当前层的所有结点个数
            int nodeCount = queue.size();
            // 将队列里的孩子节点入队，当前层结点个数-1
            while (nodeCount > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                nodeCount--;
            }
            height++;
        }
        return height;
    }
}
