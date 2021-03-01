package LeetCode.LeetCode69;

// 平方根问题
public class Solution {
    public int mySqrt(int x) {
        // l从1开始防止后面的x/mid出现异常
        int l = 1, r = (x / 2) + 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // 循环结束条件l=r+1，所以返回r才是正确答案
        return r;
    }
}
