package 剑指Offer.数组与字符串.剑指Offer53_缺失的数字;

public class Solution {
    // 法1:复制一个temp
    public int missingNumber1(int[] nums) {
        int[] temp = new int[nums.length + 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = i;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != nums[i] || i == temp.length - 1) {
                return temp[i];
            }
        }
        return -1;
    }

    // 法2:排序数组搜索,首先想到二分法
    public int missingNumber2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 正常二分:当前元素==它的索引
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                // nums[mid]!=mid,说明缺失数=右边第一个数的索引值
                // 移动右指针
                right = mid - 1;
            }
        }
        // 二分结束,left越过right到达右边第一个数
        return left;
    }
}
