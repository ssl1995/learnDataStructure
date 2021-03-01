package dataStructure.排序.heapSort.堆.练习题;

import java.util.PriorityQueue;

// 剑指Offer40：最小的k个数
// 使用jdk的优先队列
public class ToOffer40_2 {
    // 使用JDK的优先队列
    public int[] getLeastNumbers(int[] arr, int k) {
        // 实现最大堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(11, (o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++)
            if (!pq.isEmpty() && arr[i] < pq.peek()) {
                pq.remove();
                pq.add(arr[i]);
            }

        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = pq.remove();
        return res;
    }
}
