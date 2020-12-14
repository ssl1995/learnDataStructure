package ssl.sort.quickSort;


import java.util.Random;

/**
 * @Author ssl
 * @Date 2020/12/5 9:28
 * @Description 快速排序
 */
public class QuickSort {
    private QuickSort() {
    }

    public static <E extends Comparable<E>> void quickSort(E[] arr) {
        // 优化二：内存操作只生成一个random
        Random random = new Random();
        quickSort(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void quickSort(E[] arr, int l, int r, Random random) {
        if (l >= r) return;
        int p = partition(arr, l, r, random);
        // 再递归
        quickSort(arr, l, p - 1, random);
        quickSort(arr, p + 1, r, random);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        // 优化一：生成[l,r]的随机值，解决有序数组的问题
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);
        // 核心：arr[l+1...j] < v ; arr[j+1...i] >= v
        int j = l;
        for (int i = l + 1; i <= r; i++)
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, i, j);
            }

        swap(arr, l, j);
        return j;
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
