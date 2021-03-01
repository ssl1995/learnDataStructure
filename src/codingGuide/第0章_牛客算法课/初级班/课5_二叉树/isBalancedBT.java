package codingGuide.第0章_牛客算法课.初级班.课5_二叉树;

import 第3章_二叉树问题.前中后序遍历.力扣.TreeNode;

public class isBalancedBT {
    // 判断是否是平衡二叉树，需要子树的两个信息：平衡和高度
    // 定义一个该信息的类
    class BalanceAndHeightInfo {
        public boolean balanced;
        public int height;

        public BalanceAndHeightInfo(boolean b, int h) {
            this.balanced = b;
            this.height = h;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return process(root).balanced;
    }

    private BalanceAndHeightInfo process(TreeNode node) {
        if (node == null) {
            return new BalanceAndHeightInfo(true, 0);
        }
        BalanceAndHeightInfo leftInfo = process(node.left);
        BalanceAndHeightInfo rightInfo = process(node.right);
        int nodeHeight = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean nodeBalanced =
                leftInfo.balanced && rightInfo.balanced && Math.abs(leftInfo.height - rightInfo.height) <= 1;
        return new BalanceAndHeightInfo(nodeBalanced, nodeHeight);
    }
}
