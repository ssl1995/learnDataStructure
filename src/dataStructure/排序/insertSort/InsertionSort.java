package dataStructure.排序.insertSort;

import java.util.Arrays;

public class InsertionSort {
    private InsertionSort() {
    }

    // 插入排序1:背这个，性能较好，不使用交换
    public static <E extends Comparable<E>> void insertSort1(E[] data) {
        for (int i = 0; i < data.length; i++) {
            E temp = data[i];
            int j;
            // 内层循环从后往前找位置腾出
            for (j = i; j - 1 >= 0 && temp.compareTo(data[j - 1]) < 0; j--) {
                data[j] = data[j - 1];
            }
            // 空出的位置赋值temp
            data[j] = temp;
        }
    }

    //插入排序2:使用交换，性能没有上面好
    public static <E extends Comparable<E>> void insertSort2(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j].compareTo(arr[j + 1]) > 0; j++) {
                swap(arr, j, j + 1);
            }
        }
    }

    private static <E> void swap(E[] arr, int j, int i) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = {6, 2, 5, 7, 8};
        insertSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

}


