package 剑指Offer.动态规划.剑指Offer10_青蛙跳台阶;

public class Solution {

    // 和斐波那契很像,就是初始化条件不一样
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }
}
