package ssl.stack.practice;
import java.util.LinkedList;


public class LC225_1 {
    // 使用2个队列实现一个栈
    private LinkedList<Integer> q1;
    private LinkedList<Integer> q2;

    public LC225_1() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        // 保证后进的先出：q2先入队列，q1出队列入q2
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        // q1和q2交换
        LinkedList<Integer> t = q1;
        q1 = q2;
        q2 = t;
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
