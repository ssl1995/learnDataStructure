package 程序员代码面试指南.第0章_牛客算法课.初级班.课4_链表;

public class SmallerEqualBigger {
    // 问题：将单链表按照某值划分为左边小、中间相等、右边大
    // 最优解：用7个额外变量就行
    public static Node listPartition2(Node head, int pivot) {
        Node s1 = null; // small head
        Node s2 = null; // small tail
        Node e1 = null; // equal head
        Node e2 = null; // equal tail
        Node b1 = null; // big head
        Node b2 = null; // big tail
        Node next; // save next node
        // every node distributed to three lists
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (s1 == null) {
                    s1 = head;
                    s2 = head;
                } else {
                    s2.next = head;
                    s2 = head;
                }
            } else if (head.value == pivot) {
                if (e1 == null) {
                    e1 = head;
                    e2 = head;
                } else {
                    e2.next = head;
                    e2 = head;
                }
            } else {
                if (b1 == null) {
                    b1 = head;
                    b2 = head;
                } else {
                    b2.next = head;
                    b2 = head;
                }
            }
            head = next;
        }
        // 小的和相等的链表重新连接
        if (s2 != null) {
            s2.next = e1;
            e2 = (e2 == null) ? s2 : e2;
        }
        // 所有的都重新连接
        if (e2 != null) {
            e2.next = b1;
        }
        // 返回不为空的各个部分的头
        return (s1 != null) ? s1 : (e1 != null ? e1 : b1);
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }

}
