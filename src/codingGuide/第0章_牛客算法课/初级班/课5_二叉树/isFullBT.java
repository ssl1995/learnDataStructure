package codingGuide.第0章_牛客算法课.初级班.课5_二叉树;

import leetCode.LeetCode104.TreeNode;


public class isFullBT {
    class ReturnInfo {
        public int height;
        public int nodes;

        public ReturnInfo(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    public boolean isFullBT(TreeNode root) {
        ReturnInfo res = process(root);
        // 满二叉树：节点数=2^高度+1
        return res.nodes == (1 << res.height + 1);
    }

    private ReturnInfo process(TreeNode node) {
        if (node == null) {
            return new ReturnInfo(0, 0);
        }
        ReturnInfo leftInfo = process(node.left);
        ReturnInfo rightInfo = process(node.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int nodes = leftInfo.nodes + rightInfo.nodes;
        return new ReturnInfo(height, nodes);
    }
}
