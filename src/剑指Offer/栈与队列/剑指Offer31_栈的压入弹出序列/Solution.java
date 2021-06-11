package 剑指Offer.栈与队列.剑指Offer31_栈的压入弹出序列;

import java.util.LinkedList;

public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 使用一个辅助栈,模拟pushed过程,途中匹配popped
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        // 辅助栈如果匹配完了为空就是true
        return stack.isEmpty();
    }
}
