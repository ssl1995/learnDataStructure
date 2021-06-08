package codingInterview.数组与字符串.剑指Offer58_反转单词顺序;


public class Solution {

    // 法1:双指针,倒序遍历字符串,记录每个单词的首指针前一位,尾指针
    public String reverseWords1(String s) {
        String noTrimStr = s.trim();
        int last = noTrimStr.length() - 1;
        int index = last;
        StringBuilder sb = new StringBuilder();
        while (index >= 0) {
            // 倒序遍历,找到第一个' ',添加进sb中
            while (index >= 0 && noTrimStr.charAt(index) != ' ') {
                index--;
            }
            sb.append(noTrimStr.substring(index + 1, last + 1) + " ");
            // 遇到' ',遍历指针index后移
            while (index >= 0 && noTrimStr.charAt(index) == ' ') {
                index--;
            }
            // 再次遇到非' '，就让last指向下一个单词末尾
            last = index;
        }
        // 返回结果去掉每次添加单词的" "
        return sb.toString().trim();
    }

    //  法2:调用库函数,面试不推荐使用
    public String reverseWords2(String s) {
        String[] split = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            // split()遇到n个空格,会产生n-1的空字符串
            // 所以遇到空字符串,就要跳过当前循环
            if (split[i].equals("")) {
                continue;
            } else {
                sb.append(split[i] + " ");
            }
        }
        // 结果删除末尾的“ ”
        return sb.toString().trim();
    }
}
