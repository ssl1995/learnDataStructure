package 剑指Offer.数组与字符串.剑指Offer11_旋转数组的最小数字;

public class Solution {
    // 旋转数组的最小值
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        // 循环条件是<;二分查找是<=
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 数组部分旋转,目标值改为数组最右边元素
            int target = numbers[right];
            if (numbers[mid] < target) {
                // 中间值<右边值 = 右边递增
                // 最小值在左边,取得到mid
                right = mid;
            } else if (numbers[mid] > target) {
                // 中间值>右边值 = 右边递减
                // 最小值在右边,取不到mid
                left = mid + 1;
            } else {
                // 中间值=右边值,无法判断在左边还是右边,但最小值一定靠近左边,缩小mid=缩小target=right--
                right--;
            }
        }
        // 返回值是left位置的数
        return numbers[left];
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
