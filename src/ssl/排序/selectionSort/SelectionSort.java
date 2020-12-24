package ssl.排序.selectionSort;


import java.util.Arrays;

public class SelectionSort {
    private SelectionSort() {
    }

    // 选择排序1:背这个
    public static <E extends Comparable<E>> void selectionSort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                min = arr[j].compareTo(arr[min]) < 0 ? j : min;
            }
            swap(arr, i, min);
        }
    }

    // 选择排序2
    public static <E extends Comparable<E>> void selectionSort1(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int max = i;
            for (int j = i - 1; j >= 0 ; j--) {
                max = arr[j].compareTo(arr[max])>0?j:max;
            }
            swap(arr, i, max);
        }
    }



    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] nums = {9, 8, 7, 6};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
