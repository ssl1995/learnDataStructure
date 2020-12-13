package ssl.sort.insertSort;

import java.util.Arrays;

public class InsertionSort {
    private InsertionSort() {
    }

    /**
     * 插入排序1:i从前往后，j从i的前面逐步判断
     */
    public static <E extends Comparable<E>> void insertSort1(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E temp = arr[i];
            int j;
            // t比前一个元素还小，j所在元素就后移一位
            for (j = i; j - 1 >= 0 && temp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            // 循环跳出，j--相当于j=未跳出时的j-1
            // t放入当前元素位置
            arr[j] = temp;
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


    private static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // 包装类比较
        Integer[] arr1 = {1, 52, 56, 23, 3};
        Integer[] arr2 = {1, 52, 56, 23, 3};
        insertSort1(arr1);
        insertSort2(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println("-------");
        System.out.println(Arrays.toString(arr2));
        // 自定义类比较：重写compareTo比较，基于score比较

    }
}
