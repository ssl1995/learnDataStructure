package leetCode.栈和队列.LC20_有效的括号;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {


    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        map.put('?', '?');// 自定义一个符号?,放在栈底,便于快速匹配
        // 数组长度>0，但是不包含
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        stack.push('?');// 栈中初始化,添加一个判断字符?,便于快速判断
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {// 遍历s中每个元素,如果存在map中的左括号,就入栈
                stack.push(c);
            } else if (c != map.get(stack.pop())) {
                return false;
            }
        }
        // 栈初始化了一个?,长度为1
        return stack.size() == 1;
    }
}
