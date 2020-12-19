package ssl.sort.mergerSort;

import java.util.Arrays;


public class MergeSort1 {
    private MergeSort1() {

    }

    public static <E extends Comparable<E>> void mergeSort(E[] arr) {
        // 优化3：只生成一次辅助数组，并且merge中没有偏移量的操作了
        E[] temp = Arrays.copyOf(arr, arr.length);
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable<E>> void mergeSort(E[] arr, int l, int r, E[] temp) {
        // 优化2：指定长度内，使用直接插入排序，但是效果不明显，不推荐使用
        if (r - l <= 15) {
            insertSort(arr, l, r);
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid, temp);
        mergeSort(arr, mid + 1, r, temp);
        // 优化1:mid>mid+1,才归并
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r, temp);
        }
    }

    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {
        // 优化3：在mergesort之前就创建这个辅助数组，减少内存操作
        // 每次归并完，arr的l到r有序，辅助数组要更新一遍
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l, j = mid + 1;
        // 优化3：merge中没有偏移量的操作了
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j++];
            } else if (j > r) {
                arr[k] = temp[i++];
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i++];
            } else {
                arr[k] = temp[j++];
            }
        }
    }

    // 优化2：使用插入排序
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
}
