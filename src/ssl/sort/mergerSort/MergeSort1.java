package ssl.sort.mergerSort;

import java.util.Arrays;


public class MergeSort1 {
    private MergeSort1() {
    }

    public static <E extends Comparable<E>> void mergeSort(E[] arr) {
        // 优化3：只生成一次辅助数组
        E[] temp = Arrays.copyOf(arr, arr.length);
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable<E>> void mergeSort(E[] arr, int l, int r, E[] temp) {
        // 优化2：指定长度内，使用直接插入排序
        // 但如今这种优化的方式，效果并不好，所以看情况而定
        if (r - l <= 15) {
            insertSort(arr, l, r);
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid, temp);
        mergeSort(arr, mid + 1, r, temp);
        // 优化1:mid>mid+1，才归并
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r, temp);
        }
    }

    public static <E extends Comparable<E>> void insertSort(E[] arr, int l, int r) {
        for (int i = l; i < r; i++) {
            // 用temp存储当前变量
            E t = arr[i];
            int j;
            // t比前一个元素还小，j所在元素就后移一位
            for (j = i; j - 1 >= l && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            // t放入当前元素位置
            arr[j] = t;
        }
    }

    /**
     * 归并merger：
     * 已知两个有序的A和B数组，将A和B合并成有序数组
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {
        // 优化3：在mergesort之前就创建这个辅助数组，减少内存操作
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l, j = mid + 1;
        // 每轮循环为 arr[k] 赋值
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }
}
