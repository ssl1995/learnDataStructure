package ssl.sort.quickSort;


import ssl.sort.helpUtils.ArrayGenerator;
import ssl.sort.helpUtils.SortingHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author ssl
 * @Date 2020/12/5 9:28
 * @Description 双路快速排序
 */
public class QuickSort1 {
    private QuickSort1() {
    }

    public static <E extends Comparable<E>> void quickSort2ways(E[] arr) {
        // 优化二：内存操作只生成一个random
        Random random = new Random();
        quickSort2ways(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void quickSort2ways(E[] arr, int l, int r, Random random) {
        // 结束条件：和归并排序一样
        if (l >= r) return;
        // 先方法
        int p = partition(arr, l, r, random);
        // 再递归
        quickSort2ways(arr, l, p - 1, random);
        quickSort2ways(arr, p + 1, r, random);
    }

    // 双路归并，实现arr[i+1...i-1] <= v ; arr[j+1...r] >= v
    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        // 优化一：生成[l,r]的随机值，解决有序数组的问题
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);
        // arr[i+1...i-1] <= v ; arr[j+1...r] >= v
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
            // 到这里,左边i指向>=，右边j指向<=，
            // 所以交换两者，使得左边<=v,右边>=v
            swap(arr, i, j);
            // 再次移动i和j,使得j指向最后一个<=v的值
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

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr1 = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        System.out.println("随机数组测试：");
        SortingHelper.sortTest("QuickSort", arr1);
        SortingHelper.sortTest("QuickSort2ways", arr2);
        System.out.println("有序数组测试：");
        Integer[] arr3 = ArrayGenerator.generateOrderedArray(n);
        Integer[] arr4 = Arrays.copyOf(arr3, arr3.length);
        SortingHelper.sortTest("QuickSort", arr3);
        SortingHelper.sortTest("QuickSort2ways", arr4);
        System.out.println("有序数组且所有元素都是0测试：");
        Integer[] arr5 = ArrayGenerator.generateRandomArray(n, 1);
        Integer[] arr6 = Arrays.copyOf(arr5, arr5.length);
        // 栈溢出，加vm：-Xss128m
        SortingHelper.sortTest("QuickSort", arr5);
        SortingHelper.sortTest("QuickSort2ways", arr6);
    }

}
