package ssl.排序.quickSort;

import java.util.Random;

public class QuickSort2 {
    private QuickSort2() {
    }

    // 三路快排:波波老师写法
    public static <E extends Comparable<E>> void quickSort3ways(E[] arr) {
        Random random = new Random();
        quickSort3ways(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void quickSort3ways(E[] arr, int l, int r, Random random) {
        if (l >= r) return;
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);
        // 核心：arr[l+1,lt]<v ; arr[lt+1,i-1]=v ; arr[gt,r]>v
        // lt指向<的最后一个元素，i指针遍历，gt指向>的第一个元素
        int lt = l, i = l + 1, gt = r + 1;
        while (i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                swap(arr, i, lt);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                swap(arr, i, gt);
                // 原先的gt--后的值没有比较过，i继续指向它，不用i++
            } else {
                // arr[i]==arr[l]
                i++;
            }
        }
        swap(arr, l, lt);
        // 三路快排抛弃掉中间的部分，不再递归
        quickSort3ways(arr, l, lt - 1, random);
        quickSort3ways(arr, gt, r, random);
    }


    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
