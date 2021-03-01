package codingGuide.第0章_牛客算法课.初级班.课2_NlogN的排序;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 选择随机值与末尾元素交换
        swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
        int[] p = partition(arr, l, r);
        quickSort(arr, l, p[0] - 1);
        quickSort(arr, p[0] + 1, r);
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;// less指向小于区域最后一个数
        int more = r;// more指向大于区域第一个数
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        // 将大于区域第一个数与末尾基准做交换，
        // 交换完毕后，more指向等于区域最后一个数
        swap(arr, more, r);
        // 返回等于区域坐标
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
