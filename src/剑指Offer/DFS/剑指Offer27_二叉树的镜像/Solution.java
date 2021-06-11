package 剑指Offer.DFS.剑指Offer27_二叉树的镜像;

import leetCode.LeetCode104.TreeNode;
import java.util.LinkedList;

public class Solution {

    // 法1:递归法,但是要暂存左孩子节点
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 暂存left结点
        TreeNode left = root.left;
        // 左节点指向右节点
        root.left = mirrorTree1(root.right);
        // 右节点指向暂存的left结点
        root.right = mirrorTree1(left);
        // 返回当前父节点
        return root;
    }

    // 法2:交换两个值,可以用栈
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top.left != null) {
                stack.push(top.left);
            }
            if (top.right != null) {
                stack.push(top.right);
            }
            // 交换
            TreeNode temp = top.left;
            top.left = top.right;
            top.right = temp;
        }
        return root;
    }
}

