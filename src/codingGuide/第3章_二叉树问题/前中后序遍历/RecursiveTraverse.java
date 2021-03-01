package codingGuide.第3章_二叉树问题.前中后序遍历;

public class RecursiveTraverse {
    // 通用递归序：学习来到当前节点的次数
    public static void commonRecursiveTraverse(Node head) {
        // 递归结束条件
        if (head == null) {
            return;
        }
        // 第一次来到head=先序
        commonRecursiveTraverse(head.left);
        // 第二次来到head=中序
        commonRecursiveTraverse(head.right);
        // 第三次来到head=后序
    }

    // 先序递归遍历
    public static void preRecursiveTraverse(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        preRecursiveTraverse(head.left);
        preRecursiveTraverse(head.right);
    }

    // 中序递归遍历
    public static void inRecursiveTraverse(Node head) {
        if (head == null) {
            return;
        }
        inRecursiveTraverse(head.left);
        System.out.println(head.value);
        inRecursiveTraverse(head.right);
    }

    // 后序递归遍历
    public static void posRecursiveTraverse(Node head) {
        if (head == null) {
            return;
        }
        posRecursiveTraverse(head.left);
        posRecursiveTraverse(head.right);
        System.out.println(head.value);
    }
}
