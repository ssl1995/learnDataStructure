package dataStructure.排序.quickSort;


import java.util.Random;

public class QuickSort {
    private QuickSort() {
    }

    public static <E extends Comparable<E>> void quickSort(E[] arr) {
        // 优化1：内存操作只生成一个random
        Random random = new Random();
        quickSort(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void quickSort(E[] arr, int l, int r, Random random) {
        if (l >= r) return;
        // 先划分区间
        int p = partition(arr, l, r, random);
        // 在递归排序
        quickSort(arr, l, p - 1, random);
        quickSort(arr, p + 1, r, random);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        // 优化2：生成[l,r]的随机值并交换，解决有序数组的问题
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);
        // 比较基准：arr[l]
        // j指向<基准的最后一个数的索引
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            // 这里实现了>=的放右边
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        // 循环跳出，将指向<value区间最后一个元素的j与指向枢纽j的元素交换
        swap(arr, l, j);
        return j;
    }


    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
