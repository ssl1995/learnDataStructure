package codingInterview.栈与队列.剑指Offer59_II队列最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
    // 普通队列保证push、pop
    private Queue<Integer> queue;
    // 双端队列保持单调性:新加入的元素<=队尾元素
    private Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }


    public void push_back(int value) {
        // 先加元素>双端队列队尾,双端队列出队找<=的第一个元素
        while (!deque.isEmpty() && value > deque.peekLast()) {
            deque.pollLast();
        }
        // 双端队列:对头只存最大的
        deque.offerLast(value);
        queue.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int value = queue.poll();
        if (value == max_value()) {
            deque.pollFirst();
        }
        return value;
    }

    public int max_value() {
        if (deque.isEmpty()) {
            // 条件规定:max栈为空,返回-1
            return -1;
        }
        return deque.peekFirst();
    }

    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(1);
        queue.addLast(2);
        queue.addLast(3);
        queue.addLast(4);
        System.out.println(queue.peekFirst());// 1
        System.out.println(queue.peekLast());// 4
    }


}
