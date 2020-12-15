package ssl.sort.insertSort;

public class InsertionSort {
    private InsertionSort() {
    }

    // 插入排序1
    public static <E extends Comparable<E>> void insertSort1(E[] data) {
        for (int i = 0; i < data.length; i++) {
            E temp = data[i];
            int j;
            // j是遍历指针，j-1是比较指针
            for (j = i; j - 1 >= 0 && temp.compareTo(data[j - 1]) < 0; j--) {
                data[j] = data[j - 1];
            }
            // 循环跳出，执行了一次j--,跳出循环的j相当于未跳出的j-1
            // 所以还是j位置和temp交换
            data[j] = temp;
        }
    }

    // 插入排序2
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
}
