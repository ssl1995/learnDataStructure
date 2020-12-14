package ssl.sort.bubbleSort;

import ssl.sort.helpUtils.ArrayGenerator;
import ssl.sort.helpUtils.SortingHelper;

import java.util.Arrays;

/**
 * @Author ssl
 * @Date 2020/12/13 16:39
 * @Description
 */
public class BubbleSort {
    private BubbleSort() {
    }

    // i从前往后,优化：使用交换标志位
    public static <E extends Comparable<E>> void bubbleSort1(E[] arr) {
        // 只需要n-1层外部循环
        for (int i = 0; i < arr.length - 1; i++) {
            // 优化：设置交换标志位
            boolean isSwap = false;
            // 数组后面的元素已经排好序=arr[n-i,n)已经排好序
            // 现在需要在arr[n-i-1]位置上放上合适的元素
            for (int j = 0; j < arr.length - 1 - i && arr[j].compareTo(arr[j + 1]) > 0; j++) {
                swap(arr, j, j + 1);
                isSwap = true;
            }
            // 内层没有发生交换，说明前面已经都排好序了，就不用再次比较
            if (!isSwap) {
                break;
            }
        }
    }

    // i从前往后，优化:使用交换后的最后位置
    public static <E extends Comparable<E>> void bubbleSort2(E[] arr) {
        // 只需要n-1层外部循环
        for (int i = 0; i < arr.length - 1; ) {
            // 优化：设置交换标志位
            int lastSwappedIndex = 0;
            // 数组后面的元素已经排好序=arr[n-i,n)已经排好序
            // 现在需要在arr[n-i-1]位置上放上合适的元素
            for (int j = 0; j < arr.length - 1 - i && arr[j].compareTo(arr[j + 1]) > 0; j++) {
                swap(arr, j, j + 1);
                lastSwappedIndex = j + 1;
            }
            i = arr.length - lastSwappedIndex;
        }
    }

    // i从后往前
    public static <E extends Comparable<E>> void bubbleSort3(E[] arr) {
        // 只需要n-1层外部循环
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i && arr[j].compareTo(arr[j + 1]) > 0; j++) {
                swap(arr, j, j + 1);
            }
        }
    }


    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
