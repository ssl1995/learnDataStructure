package codingGuide.第0章_牛客算法课.初级班.课1_三个简单排序;

public class GetArrayMax {
    // 获取数组中最大值

    // 方法一：循环查找
    public static int getArrayMax1(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    // 方法二：迭代
    public static int getArrayMax2(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = l + (r - l) / 2;
        int leftMax = process(arr, l, mid);
        int rightMax = process(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }

}
