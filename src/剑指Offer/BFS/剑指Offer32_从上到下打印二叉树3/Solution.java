package 剑指Offer.BFS.剑指Offer32_从上到下打印二叉树3;

import leetCode.LeetCode104.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    // 之字型打印二叉树
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // 双端队列:存之字型
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offerFirst(root);
        // 先从左到右
        boolean left2Right = true;
        // 当前层的最后一个结点
        TreeNode curLast = root;
        // 下一层的最后一个结点
        TreeNode nextLast = null;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        while (!dq.isEmpty()) {
            // 从左到右遍历
            if (left2Right) {
                // 当前节点从头出,左右孩子从尾进
                root = dq.pollFirst();
                if (root.left != null) {
                    // 下一层最后打印的节点是当前层有孩子节点的节点中最先进入dq的节点
                    // 所以每一次都判断,nLast永远指向第一次进入队列的结点=出队列时最后一个一个结点
                    nextLast = (nextLast == null) ? root.left : nextLast;
                    dq.offerLast(root.left);
                }
                if (root.right != null) {
                    nextLast = (nextLast == null) ? root.right : nextLast;
                    dq.offerLast(root.right);
                }
            } else {   // 从右到左遍历
                // 当前节点从尾出,右左孩子从头进
                root = dq.pollLast();
                if (root.right != null) {
                    nextLast = (nextLast == null) ? root.right : nextLast;
                    dq.offerFirst(root.right);
                }
                if (root.left != null) {
                    nextLast = (nextLast == null) ? root.left : nextLast;
                    dq.offerFirst(root.left);
                }
            }
            // 当前结点值入temp队列
            temp.add(root.val);
            // 当前节点指向当前层最后一个结点,且队列非空
            if (root == curLast && !dq.isEmpty()) {
                left2Right = !left2Right;
                curLast = nextLast;
                nextLast = null;
                // 当前层加入到结果集
                res.add(temp);
                // 重点:temp链表必须重置
                temp = new ArrayList<>();
            }
            //当前节点指向当前层最后一个结点,且队列空 = 遍历到最后一个子树,加入到结果集即可
            if (root == curLast && dq.isEmpty()) {
                res.add(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        node2.left = node3;
        node2.right = node4;

        root.left = node1;
        root.right = node2;

        Solution solution = new Solution();
        List<List<Integer>> res = solution.levelOrder(root);

        System.out.println(res);

    }
}
