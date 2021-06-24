package 剑指Offer.树.剑指Offer55_二叉树的深度;

import leetCode.LeetCode104.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    // 法1:二叉树深度:左右子树深度最大值+1
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    // 法2:层序遍历,每遍历一层,深度加1
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> temp;
        int res = 0;
        while (!queue.isEmpty()) {
            temp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            queue = temp;
            res++;
        }
        return res;
    }
}
