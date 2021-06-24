package leetCode.栈和队列.LC225_用队列实现栈;

import java.util.LinkedList;

public class MyStack {
    // 用一个队列就可以实现栈
    private LinkedList<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        // 先记录之前队列中元素个数
        int preLen = queue.size();
        queue.add(x);
        // 保证先进后出:队列中之前的元素重新入队列
        for (int i = 0; i < preLen; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.pop();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
