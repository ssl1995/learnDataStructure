package 剑指Offer.动态规划.剑指Offer42_连续子数组最大值;

public class Solution {
    // 动态规划法:最容易理解的写法
    public int maxSubArray1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 初始化dp
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        // 最大值初始化就是nums[0],千万别是0或者整型最小值
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] <= 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 动态规划法:最简便的写法,缺点是修改了原数组,只能适合刷题
    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            max = Math.max(nums[i], max);
        }
        return max;
    }
}
