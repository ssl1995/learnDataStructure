package ssl.sort.mergerSort;

import ssl.sort.helpUtils.ArrayGenerator;
import ssl.sort.helpUtils.SortingHelper;

import java.util.Arrays;

public class MergeSort {
    private MergeSort() {
    }

    public static <E extends Comparable<E>> void mergeSort(E[] arr) {

        mergeSort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void mergeSort(E[] arr, int l, int r) {
        // 递归结束条件
        if (l >= r) {
            return;
        }
        // 分治
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        // 归并
        merge(arr, l, mid, r);
    }

    //归并merger：已知两个有序的A和B数组，将A和B合并成有序数组
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        // 归并辅助函数，copyOfRange区间是左封右开
        E[] help = Arrays.copyOfRange(arr, l, r + 1);
        // i1,i2遍历辅助数组
        int i1 = l, i2 = mid + 1;
        // i遍历原数组,太复杂,反复看视频理解
        for (int i = l; i <= r; i++) {
            // i>mid，左边部分遍历比较完毕
            if (i1 > mid) {
                arr[i] = help[i2++ - l];
            } else if (i2 > r) {
                arr[i] = help[i1++ - l];
            } else if (help[i1 - l].compareTo(help[i2 - l]) <= 0) {
                arr[i] = help[i1++ - l];
            } else {
                arr[i] = help[i2++ - l];
            }
        }
    }

    // 使用更简单的merge过程，背这个
    public static <E extends Comparable<E>> void mergeSort1(E[] arr) {
        mergeSort1(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void mergeSort1(E[] arr, int l, int r) {
        // 递归结束条件
        if (l >= r) {
            return;
        }
        // 分治
        int mid = l + (r - l) / 2;
        mergeSort(arr, 0, mid);
        mergeSort(arr, mid + 1, r);
        // 归并
        merge1(arr, 0, mid, r);
    }

    // merge1是能背的归并代码
    private static <E extends Comparable<E>> void merge1(E[] arr, int l, int mid, int r) {
        E[] help = Arrays.copyOfRange(arr, l, r + 1);
        int i = 0;
        int i1 = l, i2 = mid + 1;
        while (i1 <= mid && i2 <= r) {
            help[i++] = arr[i1].compareTo(arr[i2]) < 0 ? arr[i1++] : arr[i2++];
        }
        while (i1 <= mid) {
            help[i++] = arr[i1++];
        }
        while (i2 <= r) {
            help[i++] = arr[i2++];
        }
        // 最后记得复制回原数组
        for (int k = 0; k < help.length; k++) {
            arr[l + k] = help[k];
        }
    }

    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr1 = ArrayGenerator.generateOrderedArray(n);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        SortingHelper.sortTest("MergeSort_1", arr1);
        SortingHelper.sortTest("MergeSort", arr2);
    }

}
