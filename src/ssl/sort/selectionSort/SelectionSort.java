package ssl.sort.selectionSort;


import ssl.sort.helpUtils.ArrayGenerator;
import ssl.sort.helpUtils.SortingHelper;


public class SelectionSort {
    private SelectionSort() {
    }

    /*
        简单选择排序：每次从数组中选出最小值放到最终位置
     */
    public static <E extends Comparable<E>> void selectionSort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length && arr[j].compareTo(arr[min]) < 0; j++) {
                min = j;
            }
            swap(arr, i, min);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr1 = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("SelectionSort", arr1);
    }
}
