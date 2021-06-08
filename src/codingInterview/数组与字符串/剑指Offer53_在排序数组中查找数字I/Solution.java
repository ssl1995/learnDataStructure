package codingInterview.数组与字符串.剑指Offer53_在排序数组中查找数字I;

public class Solution {
    // 问题:在排序数组中统计数字出现的次数

    // 二分法:因为数组有序找target,思考用二分法
    public int search(int[] nums, int target) {
        // [5,7,7,8,8,10],t=8的出现的次数
        // 代码复用:8的次数=10的下标-第一个8的下标,发现可以复用二分查找代码
        return getRightMargin(nums, target) - getRightMargin(nums, target - 1);
    }

    // 返回target右边第一个数下标
    private int getRightMargin(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 经验:二分法中<=就是返回t的右边界
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 二分查找
    private int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = left - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
