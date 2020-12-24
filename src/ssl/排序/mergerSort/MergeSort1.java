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


    public static void main(String[] args) {
        Integer[] arr = {4, 3, 2, 1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
