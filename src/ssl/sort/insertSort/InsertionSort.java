package ssl.sort.insertSort;

import ssl.sort.helpUtils.ArrayGenerator;
import ssl.sort.helpUtils.SortingHelper;

import java.util.Arrays;

public class InsertionSort {
    private InsertionSort() {
    }

    /**
     * 插入排序1:i从前往后，j从i的前面逐步判断
     */
    public static <E extends Comparable<E>> void insertSort1(E[] data) {
        for (int i = 0; i < data.length; i++) {
            E temp = data[i];
            int j;
            // t比前一个元素还小，j所在元素就后移一位
            for (j = i; j - 1 >= 0 && temp.compareTo(data[j - 1]) < 0; j--) {
                data[j] = data[j - 1];
            }
            // 循环跳出，j--相当于j=未跳出时的j-1
            // t放入当前元素位置
            data[j] = temp;
        }
    }

    /**
     * 插入排序2:i从后往前，j从i的后面逐步判断
     */
    public static <E extends Comparable<E>> void insertSort2(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            E temp = arr[i];
            int j;
            for (j = i; j + 1 < arr.length && temp.compareTo(arr[j + 1]) > 0; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr1 = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("InsertionSort", arr1);
    }
}
