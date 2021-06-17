package 剑指Offer.树.剑指Offer68_二叉搜索树的最近公共祖先;

import leetCode.LeetCode104.TreeNode;

public class Solution {

    // 法1:直接迭代
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            // p,q都在root的右子树,最近公共祖先一定在右子树
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                // p,q都在root的左子树,最近公共祖先一定在左子树
                root = root.left;
            } else {
                // p,q在root的左右两边,最近公共祖先就是root
                break;
            }
        }
        return root;
    }

    // 法2:对法1进行优化,保证p.val<q.val,减少while判断条件
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        while (root != null) {
            // root比p,q中最小的还小,最近公共祖先在其右子树
            if (root.val < p.val) {
                root = root.right;
            } else if (root.val > q.val) {
                // root比p,q中最大的还大,最近公共祖先在其左子树
                root = root.left;
            } else {
                // root既不比p,q中最大的大,最小的小,最近公共祖先技术root
                break;
            }
        }
        return root;
    }

    // 法3:将迭代改成递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            // 每次迭代记录当前结果,所以每次都要return
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

}
