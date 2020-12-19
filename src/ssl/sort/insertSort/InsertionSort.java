package ssl.sort.insertSort;

public class InsertionSort {
    private InsertionSort() {
    }

    // 插入排序1:不使用交换，用temp暂存数
    public static <E extends Comparable<E>> void insertSort1(E[] data) {
        for (int i = 0; i < data.length; i++) {
            E temp = data[i];
            int j;
            for (j = i; j - 1 >= 0; j--) {
                // 后移空出位置：如果暂存值小于j-1的值
                if (temp.compareTo(data[j - 1]) < 0) {
                    data[j] = data[j - 1];
                }
            }
            // 空出的位置赋值temp
            data[j] = temp;
        }
    }

    //插入排序3:使用交换
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

}


