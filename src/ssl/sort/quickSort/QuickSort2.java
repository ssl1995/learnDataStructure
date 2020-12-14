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
public class QuickSort2 {
    private QuickSort2() {
    }

    public static <E extends Comparable<E>> void quickSort3ways(E[] arr) {
        // 优化二：内存操作只生成一个random
        Random random = new Random();
        quickSort3ways(arr, 0, arr.length - 1, random);
    }
    // 三路归并：实现arr[l+1,lt]<v ; arr[lt+1,i-1]=v ; arr[gt,r]>v
    private static <E extends Comparable<E>> void quickSort3ways(E[] arr, int l, int r, Random random) {
        // 结束条件
        if (l >= r) return;
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);
        // 核心：arr[l+1,lt]<v ; arr[lt+1,i-1]=v ; arr[gt,r]>v
        int lt = l, i = l + 1, gt = r + 1;
        while (i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                swap(arr, i, lt);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                swap(arr, i, gt);
                // 原先的gt--后的值没有比较过，所以保留不用i++
            } else {
                // arr[i]==arr[l]，i++就行
                i++;
            }
        }
        swap(arr, l, lt);
        quickSort3ways(arr, l, lt - 1, random);
        // 三路快排抛弃掉中间的部分，不再递归
        quickSort3ways(arr, gt, r, random);
    }


    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 100000;
        // 测试随机且数字一样的数组，三路比二路还快
        Integer[] arr1 = ArrayGenerator.generateRandomArray(n, 1);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        // +Xss128m
        SortingHelper.sortTest("QuickSort", arr1);
        SortingHelper.sortTest("QuickSort2ways", arr2);
        SortingHelper.sortTest("QuickSort3ways", arr3);

    }

}
