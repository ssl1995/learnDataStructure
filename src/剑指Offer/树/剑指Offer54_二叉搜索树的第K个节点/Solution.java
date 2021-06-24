package 剑指Offer.树.剑指Offer54_二叉搜索树的第K个节点;

import leetCode.LeetCode104.TreeNode;

import java.util.ArrayList;

public class Solution {

    // 法1:常规的中序遍历，二叉搜索树中序遍历课获得递增数组
    public int kthLargest1(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrderByLR(root, list);
        // 第1大的数->排序后第size-1个数
        // 第k大的数->排序后第size-k个数
        return list.get(list.size() - k);
    }


    private void inOrderByLR(TreeNode root, ArrayList list) {
        if (root == null) {
            return;
        }
        inOrderByLR(root.left, list);
        list.add(root.val);
        inOrderByLR(root.right, list);
    }


    // 法2:右中左的中序遍历
    private int res;
    private int k;

    public int kthLargest2(TreeNode root, int k) {
        this.res = 0;
        this.k = k;
        inOrderByRL(root);
        return res;
    }


    private void inOrderByRL(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderByRL(root.right);
        // 提前返回,下一层返回时,如果k=0说明已经找到
        if (k == 0) {
            return;
        }
        // k=k-1;
        k--;
        // 记录结果:k-1后为0,说明就是第k个大的数,记录结果
        if (k == 0) {
            res = root.val;
        }
        inOrderByRL(root.left);
    }

}
