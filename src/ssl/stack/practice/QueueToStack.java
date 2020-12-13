package ssl.stack.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author ssl
 * @Date 2020/12/10 13:05
 * @Description
 */
public class QueueToStack {
    // 使用一个队列实现
    private Queue<Integer> queue;

    public QueueToStack() {
        queue = new LinkedList<>();
    }

    /*
    push：
     1.未加入元素时，先记录队列长度
     2.队列元素出队再入队，保证交换顺序
     */
    public void push(int x){
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }
    public int top(){
        return queue.peek();
    }
    public int pop(){
        return queue.poll();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

}
