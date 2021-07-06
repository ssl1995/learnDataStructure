package 牛客算法课.初级班.课5_二叉树;

import leetCode.LeetCode104.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class TreeMaxWidth {
    private int maxWidth;
    private Map<Integer, Integer> map;

    public int widthOfBinaryTree(TreeNode root) {
        maxWidth = 0;
        map = new HashMap<>();
        dfs(root, 0, 0);
        return maxWidth;
    }

    private void dfs(TreeNode root, int depth, int pos) {
        if (root == null) return;
        // putIfAbsent():key不存在就直接put，存在就沿用旧的value
        map.putIfAbsent(depth, pos);
        maxWidth = Math.max(maxWidth, pos - map.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }
}
