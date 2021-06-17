package 剑指Offer.位运算.剑指Offer16_数值的整数次方;

public class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        // n=−2147483648, n= -n会溢出。用long接受n即可
        long b = n;
        double res = 1.0;
        // n为负数时,转换x和取整数n
        if (n < 0) {
            x = 1 / x;
            b = -b;
        }
        // b每次都右移算当前二进制最右边的数,所以b每次搜缩小1/2
        // 当缩小到(1>>1)=0时,循环结束
        while (b != 0) {
            // 计算b最右边的二进制位数是0还是1
            // 是1,结果集乘当前的xi
            if ((b & 1) == 1) {
                res *= x;
            } else {
                res *= 1;
            }
            // 无论b最右边是几,都要计算下一轮的xi=x^2
            x *= x;
            // b二进制位右移一位,因为此时b=|b|,有符号右移还是无符号右移都行
            b >>= 1;
        }
        return res;
    }
}
