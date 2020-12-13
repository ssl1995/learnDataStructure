package ssl.sort.quickSort;



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

    private static <E extends Comparable<E>> void quickSort3ways(E[] arr, int l, int r, Random random) {
        // 结束条件：和归并排序一样
        if (l >= r) return;
        // 优化一：生成[l,r]的随机值，解决有序数组的问题
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
                // 这里i和gt交换了，所以不用移动i++
            } else {
                i++;
            }
        }
        swap(arr, l, lt);
        quickSort3ways(arr, l, lt - 1, random);
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
