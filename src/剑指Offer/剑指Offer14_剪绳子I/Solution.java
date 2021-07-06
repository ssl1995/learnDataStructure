package 剑指Offer.剑指Offer14_剪绳子I;

public class Solution {

    // 法:数学规律法
    public int cuttingRope(int n) {
        // 题目规定:2<=n<=58
        if (n <= 3) {
            return n - 1;
        }
        // 求n能分成3的几段
        int a = n / 3;
        // 求n最后剩余3的余数
        int b = n % 3;
        if (b == 0) {// 余0,直接返回3^a为最大乘积
            return (int) Math.pow(3, a);
        } else if (b == 1) {// 余1,将3+1转换为2乘2,因为3*1<2*2
            return (int) Math.pow(3, a - 1) * (2 * 2);
        }
        // 余2,直接返回3^a*(2),最后一段不需要拆分
        return (int) Math.pow(3, a) * (2);
    }
}
