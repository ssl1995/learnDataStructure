package ssl.sort.selectionSort;


import java.util.Arrays;


public class SelectionSort {

    // 构造器私有化
    private SelectionSort() {
    }

    /*
        简单选择排序：每次从数组中选出最小值放到最终位置
     */
    public static <E extends Comparable<E>> void selectionSort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
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
        // 包装类比较
        Integer[] arr = {1, 52, 56, 23, 3};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("-------");
        // 自定义类比较：重写compareTo比较，基于score比较
        Student[] students = {
                new Student("c", 1),
                new Student("b", 3),
                new Student("a", 2)};
        selectionSort(students);
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
