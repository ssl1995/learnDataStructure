package ssl.排序.bubbleSort;

public class BubbleSort {
    private BubbleSort() {
    }

    // 冒泡排序1:优化设置交换标志位
    public static <E extends Comparable<E>> void bubbleSort1(E[] arr) {
        // 外层实现比较次数：n-1次
        for (int i = 0; i < arr.length - 1; i++) {
            // 优化：设置交换标志位
            boolean isSwap = false;
            // 内层实现相邻元素比较：每趟只比较j和j+1的元素
            for (int j = 0; j < arr.length - 1 - i && arr[j].compareTo(arr[j + 1]) > 0; j++) {
                swap(arr, j, j + 1);
                isSwap = true;
            }
            // 内层没有发生交换，说明前面已经都排好序了，就不用再次比较
            if (!isSwap) {
                break;
            }
        }
    }

    // 冒泡排序2:优化设置最后交换位置，取消掉i++
    public static <E extends Comparable<E>> void bubbleSort2(E[] arr) {
        for (int i = 0; i < arr.length - 1; ) {
            int lastSwappedIndex = 0;
            for (int j = 0; j < arr.length - 1 - i && arr[j].compareTo(arr[j + 1]) > 0; j++) {
                swap(arr, j, j + 1);
                // 最后交换位置肯定是靠后的j+1
                lastSwappedIndex = j + 1;
            }
            i = arr.length - lastSwappedIndex;
        }
    }

    // 冒泡排序3:从后往前比较，这种写法比较好记
    public static <E extends Comparable<E>> void bubbleSort3(E[] arr) {
        // 只需要n-1层外部循环
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i && arr[j].compareTo(arr[j + 1]) > 0; j++) {
                swap(arr, j, j + 1);
            }
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
