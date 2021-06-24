package leetCode.栈和队列.LC232_用栈实现队列;

import java.util.LinkedList;

public class MyQueue {

    private LinkedList<Integer> stackPush;
    private LinkedList<Integer> stackPop;

    public MyQueue() {
        stackPush = new LinkedList<>();
        stackPop = new LinkedList<>();
    }

    // 均摊时间复杂度:定义一个push2pop的函数,使得push栈往pop栈倒入元素保证先进先出
    private void push2pop() {
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }


    public void push(int x) {
        // 队列中加入新元素,都要先push2pop“倒一次”,保证先进先出特性
        push2pop();
        stackPush.push(x);
    }


    public int pop() {
        if (empty()) {
            return -1;
        }
        // 出队前,“倒一次”保证最新值
        push2pop();
        return stackPop.pop();
    }


    public int peek() {
        if (empty()) {
            return -1;
        }
        // 取队头元素时,"倒一次"保证最新值
        push2pop();
        return stackPop.peek();
    }


    public boolean empty() {
        return stackPush.isEmpty() && stackPop.isEmpty();
    }
}
