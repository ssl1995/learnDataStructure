package ssl.sort.selectionSort;


public class SelectionSort {
    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void selectionSort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length && arr[j].compareTo(arr[minIndex]) < 0; j++) {
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
