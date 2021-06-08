package codingInterview.数组与字符串.剑指Offer66_构建乘积数组;

public class Solution {
    // 类似动态规划,仔细学习并入门
    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[]{};
        }
        int n = a.length;
        // b[i]:a[i]之前所有数的乘积(不包括a[i])
        int[] b = new int[n];
        b[0] = 1;
        // temp:a[i]之后的乘积(不包括a[i])
        int temp = 1;
        // 从i=1往后遍历,计算b[i]
        for (int i = 1; i < n; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        // 从i=n-2往前遍历,计算b[i]*temp,赋值回b[i]
        for (int i = n - 2; i >= 0; i--) {
            // temp为i之后的数相乘的结果
            temp *= a[i + 1];
            b[i] *= temp;
        }
        return b;
    }
}
