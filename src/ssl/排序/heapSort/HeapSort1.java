package ssl.排序.heapSort;


public class HeapSort1 {
    private HeapSort1() {

    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 1.让数组变成大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        // 2.最后一个位置和堆顶位置交换,n--,此时最大值放在最终位置
        int size = arr.length;
        swap(arr, 0, --size);
        // 3.从0-size大根堆化
        while (size > 0) {
            heapIfy(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    // 将数组转换成大根堆,与父节点不断比较，交换最大值
    private static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    private static void heapIfy(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        while (left < size) {
            // 1. index和左、右子树找最大值
            int largest = left + 1 < size &&
                    arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            // 判断最大值是否等于该节点
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
