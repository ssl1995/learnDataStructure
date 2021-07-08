package 牛客算法课.初级班.课3_堆排序和桶排序.Q01_堆排序;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortArrayDistanceLessK {
    /*
        已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。
        请选择一个合适的 排序算法针对这个数据进行排序
     */
    public static void sortedArrDistanceLessK(int[] arr, int k) {
        // 默认小根堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 大根堆
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < Math.min(arr.length, k); i++) {
            minHeap.add(arr[i]);
        }
        int index = 0;
        for (int i = k; i < arr.length; i++) {
            minHeap.add(arr[i]);
            arr[index++] = minHeap.poll();
        }
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 6, 5};
        sortedArrDistanceLessK(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

}
