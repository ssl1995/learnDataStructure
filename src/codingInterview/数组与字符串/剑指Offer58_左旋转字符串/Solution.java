package codingInterview.数组与字符串.剑指Offer58_左旋转字符串;

public class Solution {
    // 法1:使用String库函数subString()
    public String reverseLeftWords1(String s, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n));// [n,s.len]
        sb.append(s, 0, n);// [0,n]
        return sb.toString();
    }

    // 法2:
    public String reverseLeftWords2(String s, int n) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < n + len; i++) {
            // 使用取余运算简化代码=越过len,从头开始
            sb.append(s.charAt(i % len));
        }
        return sb.toString();
    }
}
