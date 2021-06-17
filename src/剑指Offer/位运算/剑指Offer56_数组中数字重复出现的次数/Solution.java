package 剑指Offer.位运算.剑指Offer56_数组中数字重复出现的次数;

import java.util.Arrays;

public class Solution {

    public int[] singleNumbers(int[] nums) {
        int r1 = 0, r2 = 0;
        int m = 0, n = 1;
        // 1.m=r1^r2
        for (int num : nums) {
            m ^= num;
        }
        // 2.找出r1,r2不相同的第一位二进制数,以此来分组
        while ((m & n) == 0) {
            n <<= 1;
        }
        // 3.按照第一个二进制位不同,将nums分为一组含r1分,另一组含r2的两组
        for (int num : nums) {
            // 4.每一组分别进行异或
            if ((num & n) == 0) {
                r1 ^= num;
            } else {
                r2 ^= num;
            }
        }
        return new int[]{r1, r2};
    }

    // 先学习:一个数组中除一个数字外，其余数字出现了两次，找出这个数字
    public int oneNumbers(int[] nums) {
        // 0与任何数异或都为任何数本身
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
