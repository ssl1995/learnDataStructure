package ssl.排序.heapSort;

import ssl.排序.heapSort.堆.MaxHeap;


public class HeapSort {
    private HeapSort() {

    }

    // 堆排序：原地堆排序
    public static <E extends Comparable<E>> void heapSort2(E[] arr) {
        if (arr.length <= 1) {
            return;
        }
        // 1.将随机数组转换成最大堆，数组首位将是[0.n)最大值
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            siftDown(arr, i, arr.length);
        }
        // 2.依次交换数组首位（最大值）和数组末尾，对剩下的[0,n-1...)依次进行下沉操作
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            siftDown(arr, 0, i);
        }

    }

    // 对 arr[0, n) 所形成的最大堆中，索引为k的父节点元素，进行下沉操作
    private static <E extends Comparable<E>> void siftDown(E[] arr, int k, int n) {
        while (2 * k + 1 < n) {
            //
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0) {
                j++;
            }
            // arr[j] 是 leftChild 和 rightChild 中的最大值
            if (arr[k].compareTo(arr[j]) >= 0) {
                break;
            }
            swap(arr, k, j);
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
