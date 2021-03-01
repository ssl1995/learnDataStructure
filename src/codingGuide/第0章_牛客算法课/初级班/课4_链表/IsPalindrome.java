package codingGuide.第0章_牛客算法课.初级班.课4_链表;


public class IsPalindrome {

    // 机试方法：使用一个栈，功能实现即可
    // 面试方法：空间复杂度为O(1)
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 1.快指针n2,慢指针n1,初始化为head
        // 结束时，慢指针指向中间(奇数个数)，慢指针指向中间靠左位置(偶数个数)
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        // 2.慢指针n1.next置空，n1反转后半部链表
        n2 = n1.next;
        n1.next = null;
        Node n3;
        // while结束，n1指向末尾节点,n2、n3都为空
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        // 3.n1、n3指向末尾，n2指向头结点，开始遍历判断是否是回文结构
        n3 = n1;
        n2 = head;
        boolean isPalindrome = true;
        // while结束，n1、n2指向null，n3还在末尾节点
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                isPalindrome = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        // 4.恢复右边链表
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return isPalindrome;
    }

}
