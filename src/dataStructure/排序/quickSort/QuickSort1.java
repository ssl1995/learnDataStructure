package dataStructure.排序.quickSort;

import java.util.Random;

public class QuickSort1 {
    private QuickSort1() {
    }

    // 双路快速排序
    public static <E extends Comparable<E>> void quickSort2ways(E[] arr) {
        Random random = new Random();
        quickSort2ways(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void quickSort2ways(E[] arr, int l, int r, Random random) {
        if (l >= r) return;
        int p = partition(arr, l, r, random);
        quickSort2ways(arr, l, p - 1, random);
        quickSort2ways(arr, p + 1, r, random);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);
        // i指向<=的区间的后一个元素，j指向>=区间的前一个元素
        // 初始化i指向l前一个位置，j指向数组末尾
        int i = l + 1, j = r;
        while (true) {
            while (i <= j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }
            while (i <= j && arr[j].compareTo(arr[l]) > 0) {
                j--;
            }
            // 前面有i++,j--,判断一下i>=j
            if (i >= j) {
                break;
            }
            // 走到这里，说明左边的j指向>=准基，右边的i指向<=准基
            // 于是，就交换，将j指向的大的数换到i的位置上
            swap(arr, i, j);
            // 移动指针
            i++;
            j--;
        }
        // 将j和目标值l交换
        swap(arr, l, j);
        return j;
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
