package 剑指Offer.数组与字符串.剑指Offer67_字符串转换为整数;

public class Solution {

    public int strToInt(String str) {
        // 1.原数组去首位空格后转换为字符数组
        char[] c = str.trim().toCharArray();
        if (c.length == 0) {
            return 0;
        }
        // 2.定义res和res*后的边界
        int res = 0, boundary = Integer.MAX_VALUE / 10;
        // 3.index为第一个非负号的数(正号/数字/字符)索引;sign记录正负号
        int index = 1, sign = 1;
        if (c[0] == '-') {
            sign = -1;
        } else if (c[0] != '+') {
            index = 0;
        }
        // 4.从index开始遍历
        for (int i = index; i < c.length; i++) {
            // 非数字字符,遍历结束
            if (c[i] < '0' || c[i] > '9') {
                break;
            }
            // res = res*10+c[i],所以res与(最大值/10=214748364)做比较
            // 1.res=最大值/10 且 c[i]>'7',乘积后必越界
            // 2.res>最大值/10 乘积后必越界
            if (res > boundary || res == boundary && c[i] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (c[i] - '0');
        }
        return sign * res;
    }
}
