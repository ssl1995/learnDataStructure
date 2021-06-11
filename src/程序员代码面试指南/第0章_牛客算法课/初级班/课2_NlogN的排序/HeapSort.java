package 程序员代码面试指南.第0章_牛客算法课.初级班.课2_NlogN的排序;

import java.util.Arrays;

public class HeapSort {
    // 堆排序
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 第一种大根堆方式：
        /* for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }*/
        // 第二种大根堆方式：复用heapIfy方法
        for (int i = arr.length - 1; i >= 0; i--) {
            heapIfy(arr, i, arr.length);
        }
        int heapSize = arr.length;// 记录个数
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapIfy(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    // index的数，能否往上移动
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // index的数，能否往下移动
    private static void heapIfy(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            // 左右孩子最大值
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            // 左右孩子最大值和index比较后的最大值
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            // 交换index和最大值索引
            swap(arr, index, largest);
            // 当前index变为最大值索引
            index = largest;
            // 更新左孩子节点
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
