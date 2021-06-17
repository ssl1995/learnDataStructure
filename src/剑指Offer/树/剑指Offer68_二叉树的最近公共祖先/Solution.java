package 剑指Offer.树.剑指Offer68_二叉树的最近公共祖先;

import leetCode.LeetCode104.TreeNode;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 定义递归结束条件:遇到null或p或q就返回
        if (root == null || root == p || root == q) {
            return root;
        }
        // 设当前节点为cur,使用后序遍历记录当前节点的左右子树情况,用left和right接受
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 递归结束条件:null或q或q,当两边都不为空时,cur必为其最近公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 一null一不null,不null的节点：1.是p或q 2.是p,q的最近公共祖先
        // 所以返回非null节点即可
        return left != null ? left : right;
    }
}
