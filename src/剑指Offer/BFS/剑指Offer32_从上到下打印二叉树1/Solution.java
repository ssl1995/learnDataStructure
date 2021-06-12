package 剑指Offer.BFS.剑指Offer32_从上到下打印二叉树1;

import leetCode.LeetCode104.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        // 方法:从上到下打印二叉树,利用队列的先进先出的特性
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode pop = queue.poll();
            temp.add(pop.val);
            if (pop.left != null) {
                queue.add(pop.left);
            }
            if (pop.right != null) {
                queue.add(pop.right);
            }
        }
        int[] res = new int[temp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = temp.get(i);
        }
        return res;
    }
}
