package 剑指Offer.位运算.剑指Offer65_不用加减乘除做加法;

public class Solution {

    // 加法 = 无进位和+进位,出现了加法,又不能使用算术原算法,这本身就是一种迭代or递归

    // 法1:递归法
    public int add1(int a, int b) {
        // a,b=0时，返回a
        if (b == 0) {
            return a;
        }
        // b!=0时,递归:加法= 无进位和+进位
        return add1(a ^ b, (a & b) << 1);
    }

    // 法2:迭代法
    public int add2(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }
}
