package 剑指Offer.数学.剑指Offer44_数字序列中的某一位数字;

public class Solution {

    public int findNthDigit(int n) {
        // 数位数位,1~9数位为1
        int digit = 1;
        // 数字在数位中的初试范围,1~9从1开始
        long start = 1;
        // 每个数位中数字的数量,1~9中有9位数
        long count = 9;
        // 1.循环结束:获得属于的数位,以及属于该数位的第几位=用n来记录
        while (n > count) {
            n -= count;
            digit++;
            start *= 10;
            // 计算下一轮的count=9*start*digit
            count = (9 * start) * digit;
        }
        // 2.计算属于该数位的哪个数字,因为是start是第0个数字，所以是n-1
        long num = start + (n - 1) / digit;
        // 3.确定是该数字下的哪一位数,因为String.charAt是从0开始索引,所以是n-1
        int index = (n - 1) % digit;
        return String.valueOf(num).charAt(index) - '0';
    }
}
