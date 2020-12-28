package ssl.排序.mergerSort;

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
        // 优化2：指定长度内，可以使用直接插入排序优化，但是效果不会明显，不推荐使用
        if (l >= r) {
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
        System.arraycopy(arr, l, temp, l, r - l + 1);
        // p,q遍历左右数组
        int p = l, q = mid + 1;
        // i遍历原数组
        for (int i = l; i <= r; i++) {
            if (p > mid) {
                arr[i] = temp[q++];
            } else if (q > r) {
                arr[i] = temp[p++];
            } else if (temp[p].compareTo(temp[q]) <= 0) {
                arr[i] = temp[p++];
            } else {
                arr[i] = temp[q++];
            }
        }
    }


    public static void main(String[] args) {
        Integer[] arr = {4, 3, 2, 1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
