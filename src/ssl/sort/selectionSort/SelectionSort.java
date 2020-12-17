package ssl.sort.selectionSort;


public class SelectionSort {
    private SelectionSort() {
    }
    // 选择排序:从左到右
    public static <E extends Comparable<E>> void selectionSort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length && arr[j].compareTo(arr[minIndex]) < 0; j++) {
                minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }
    // 选择排序：从右向左
    public static <E extends Comparable<E>> void selectionSort1(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int minIndex = i;
            for (int j = i; j >= 0 && arr[j].compareTo(arr[minIndex]) < 0; j--) {
                minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
