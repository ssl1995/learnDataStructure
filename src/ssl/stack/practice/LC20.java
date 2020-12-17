package ssl.stack.practice;

import java.util.Stack;

/**
 * 力扣20题：有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 */
public class LC20 {
    public boolean isValid(String s) {
        /*
            1. 遍历字符是左括号入栈
            2. 否则就出栈顶元素：先判断栈空，用当前元素和栈顶元素判断
            3. 返回：栈是否为空，为空则匹配成功
         */
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
