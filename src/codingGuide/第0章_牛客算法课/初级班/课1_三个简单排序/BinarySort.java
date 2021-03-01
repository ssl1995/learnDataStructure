package codingGuide.第0章_牛客算法课.初级班.课1_三个简单排序;

public class BinarySort {

    public static void main(String[] args) {
        int[] arr = {12, 13, 54, 12};
        int res = BinarySort.binarySort(arr, 13);
        System.out.println(res);
    }

    // 标准二分查找
    public static int binarySort(int[] arr, int t) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == t) {
                return mid;
            } else if (arr[mid] < t) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    // 在arr上，找满足>=value的最左位置
    public static int nearestIndex(int[] arr, int t) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int l = 0, r = arr.length - 1;
        int index = -1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= t) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return index;
    }

    // 局部最小值问题：无序数组，相邻两数必不相等，找出局部最小值的索引
    public static int getLessIndex(int[] arr, int t) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 最左边爬坡，局部最小值就是0位置
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        // 最后边下坡，局部最小是就是末尾位置
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        // 否则，哪怕无序，也可以二分
        int l = 1, r = arr.length - 2, mid = 0;
        while (l < r) {
            mid = l + (r - l) / 2;
            // mid左边爬坡
            if (arr[mid] > arr[mid - 1]) {
                r = mid - 1;
            }// mid右边爬坡
            else if (arr[mid] > arr[mid + 1]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;
    }


}
