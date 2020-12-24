package ssl.排序.heapSort;

import ssl.排序.heapSort.堆.MaxHeap;

public class HeapSort {
    private HeapSort() {

    }

    // 堆排序2：原地堆排序
    public static <E extends Comparable<E>> void heapSort2(E[] data) {
        if (data.length <= 1) {
            return;
        }
        // 将随机数组转换成最大堆，heapIfy:从最后一个非叶子结点开始
        for (int i = (data.length - 1 - 1) / 2; i >= 0; i--) {
            siftDown(data, i, data.length);
        }
        // 交换最大堆最大值和数组末尾值
        for (int i = data.length - 1; i >= 0; i--) {
            swap(data, 0, i);
            siftDown(data, 0, i);
        }

    }

    // 对 data[0, n) 所形成的最大堆中，索引 k 的元素，执行 siftDown
    private static <E extends Comparable<E>> void siftDown(E[] data, int k, int n) {
        while (2 * k + 1 < n) {
            int j = 2 * k + 1; // 在此轮循环中,data[k]和data[j]交换位置
            if (j + 1 < n && data[j + 1].compareTo(data[j]) > 0)
                j++;
            // data[j] 是 leftChild 和 rightChild 中的最大值
            if (data[k].compareTo(data[j]) >= 0)
                break;

            swap(data, k, j);
            k = j;
        }
    }
    // 堆排序1:使用自己的MaxHeap,看一遍即可
    public static <E extends Comparable<E>> void heapSort1(E[] data) {
        // 所有元素放进最大堆中，实现从大到小排序
        MaxHeap<E> maxHeap = new MaxHeap<>();
        for (E e : data) {
            maxHeap.add(e);
        }
        // 取出最大堆中元素，重新放进数组中，实现排序
        for (int i = data.length - 1; i >= 0; i--) {
            data[i] = maxHeap.extractMax();
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
