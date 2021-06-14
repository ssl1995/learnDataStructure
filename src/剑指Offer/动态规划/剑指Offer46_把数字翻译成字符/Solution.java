package 剑指Offer.动态规划.剑指Offer46_把数字翻译成字符;

public class Solution {
    // 动态规划:最容易理解的写法
    public int translateNum1(int num) {
        // 由于num是数字,转换为字符串进行遍历
        String str = String.valueOf(num);
        int n = str.length();
        // dp数组长度为n+1,因为假设空字符占1位,翻译为1次
        // 所以初始化空字符和第一个num位数上的数字可翻译数都为1次
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        // i从2开始,因为subString第二个参数是开区间,两位数至少包含0、1位,所以i从2开始
        for (int i = 2; i <= n; i++) {
            // 从前两个字符组成的数字开始
            String subStr = str.substring(i - 2, i);
            // 组成数字次数:两位数在[10,25]之间才能被翻译,除此之外都不能被整体翻译
            int count = (subStr.compareTo("10") >= 0 && subStr.compareTo("25") <= 0) ? dp[i - 1] + dp[i - 2] : dp[i - 1];
            dp[i] = count;
        }
        return dp[n];
    }

    // 动态规划:将上述方法dp数组转化两个数迭代
    public int translateNum2(int num) {
        // 由于num是数字,转换为字符串进行遍历
        String str = String.valueOf(num);
        int n = str.length();
        int a = 1, b = 1;
        // i从2开始,因为subString第二个参数是开区间,两位数至少包含0、1位,所以i从2开始
        for (int i = 2; i <= n; i++) {
            // 从前两个字符组成的数字开始
            String subStr = str.substring(i - 2, i);
            // 组成数字次数:两位数在[10,25]之间才能被翻译,除此之外都不能被整体翻译
            int count = (subStr.compareTo("10") >= 0 && subStr.compareTo("25") <= 0) ? a + b : b;
            a = b;
            b = count;
        }
        // 返回b,因为b每次保存count
        return b;
    }

}
