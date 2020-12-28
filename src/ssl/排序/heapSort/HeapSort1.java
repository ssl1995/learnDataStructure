package ssl.排序.heapSort;


import java.util.Arrays;

public class HeapSort1 {
    private HeapSort1() {

    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 1.让数组变成大根堆,数组第一位变成最大值
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        // 2.交换数组第一位和末尾，进行堆化调整操作
        int size = arr.length;
        swap(arr, 0, --size);
        // 3.从0-size大根堆化
        while (size > 0) {
            heapIfy(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    // 转成大根堆
    private static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }
    // 大根堆化
    private static void heapIfy(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        while (left < size) {
            // 1.找出左右孩子中的最大值和父节点作比较
            int largest = left + 1 < size &&
                    arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            // 2.如果最大值还是当前索引，就停止堆化调整
            if (largest == index) {
                break;
            }
            // 2.找到最大值就交换
            swap(arr, largest, index);
            index = largest;
            left = 2 * index + 1;
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
