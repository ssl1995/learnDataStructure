package ssl.sort.quickSort;


import java.util.Random;

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
        quickSort(arr, l, p - 1, random);
        quickSort(arr, p + 1, r, random);
    }

    // j指向小于v的最后一个元素，i从l+1遍历末尾
    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        // 优化一：生成[l,r]的随机值，解决有序数组的问题
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);
        // 核心：arr[l+1...j] < v ; arr[j+1...i] >= v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        // 单路快排出现的问题：如果相同元素过多，每次都比较，然后发生无意义的交换
        swap(arr, l, j);
        return j;
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
