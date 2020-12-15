package ssl.sort.helpUtils;


import ssl.sort.bubbleSort.BubbleSort;
import ssl.sort.heapSort.HeapSort;
import ssl.sort.insertSort.InsertionSort;
import ssl.sort.mergerSort.MergeSort;
import ssl.sort.mergerSort.MergeSort1;
import ssl.sort.mergerSort.MergeSort2;
import ssl.sort.quickSort.QuickSort;
import ssl.sort.quickSort.QuickSort1;
import ssl.sort.quickSort.QuickSort2;
import ssl.sort.selectionSort.SelectionSort;
import ssl.sort.shellSort.ShellSort;

public class SortingHelper {

    private SortingHelper() {
    }

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i - 1].compareTo(arr[i]) > 0)
                return false;
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortname, E[] arr) {

        long startTime = System.nanoTime();
        if (sortname.equals("SelectionSort"))
            SelectionSort.selectionSort(arr);
        else if (sortname.equals("InsertionSort"))
            InsertionSort.insertSort1(arr);
        else if (sortname.equals("MergeSort"))
            MergeSort.mergeSort(arr);
        else if (sortname.equals("MergeSort1"))
            MergeSort1.mergeSort(arr);
        else if (sortname.equals("MergeSort2"))
            MergeSort2.mergeSortBu(arr);
        else if (sortname.equals("QuickSort"))
            QuickSort.quickSort(arr);
        else if (sortname.equals("QuickSort2ways"))
            QuickSort1.quickSort2ways(arr);
        else if (sortname.equals("QuickSort3ways"))
            QuickSort2.quickSort3ways(arr);
        else if (sortname.equals("HeapSort1"))
            HeapSort.heapSort1(arr);
        else if (sortname.equals("HeapSort2"))
            HeapSort.heapSort2(arr);
        else if (sortname.equals("bubbleSort1"))
            BubbleSort.bubbleSort1(arr);
        else if (sortname.equals("bubbleSort2"))
            BubbleSort.bubbleSort2(arr);
        else if (sortname.equals("ShellSort1"))
            ShellSort.shellSort1(arr);
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;

        if (!SortingHelper.isSorted(arr))
            throw new RuntimeException(sortname + " failed");
        System.out.println(String.format("%s , n = %d : %f s", sortname, arr.length, time));
    }
}