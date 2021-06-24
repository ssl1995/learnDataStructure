package 数据结构.树.练习题.力扣.力扣226_翻转二叉树;

import leetCode.LeetCode104.TreeNode;

import java.util.LinkedList;

public class Solution {

    // 法1:递归法
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }

    // 法2:迭代法
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.add(root);
        while (!queue.isEmpty()) {
            // 当前队列出队
            TreeNode poll = queue.poll();
            // 交换出队元素的左右孩子节点
            TreeNode temp = poll.left;
            poll.left = poll.right;
            poll.right = temp;
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return root;
    }
}
