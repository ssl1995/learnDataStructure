package 剑指Offer.动态规划.剑指Offer49_丑数;

public class Solution {

    // 返回第n个丑数,丑数是只含2,3,5的因数
    public int nthUglyNumber(int n) {
        int indexA = 0, indexB = 0, indexC = 0;
        int[] dp = new int[n];
        // 初始化第一个丑数为1
        dp[0] = 1;
        // 从dp[1]开始选
        for (int i = 1; i < n; i++) {
            // dp[i]=min{dp[indexA],dp[indexB],dp[indexC]}
            int n1 = dp[indexA] * 2;
            int n2 = dp[indexB] * 3;
            int n3 = dp[indexC] * 5;
            dp[i] = Math.min(Math.min(n1, n2), n3);
            // 谁被选中作为最小值的index,谁就后移一位
            if (dp[i] == n1) {
                indexA++;
            }
            if (dp[i] == n2) {
                indexB++;
            }
            if (dp[i] == n3) {
                indexC++;
            }
        }
        return dp[n - 1];
    }
}
