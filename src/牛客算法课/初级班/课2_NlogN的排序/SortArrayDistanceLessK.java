package 牛客算法课.初级班.课2_NlogN的排序;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortArrayDistanceLessK {
    /*
        已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。
        请选择一个合适的 排序算法针对这个数据进行排序
     */
    public static void sortedArrDistanceLessK(int[] arr, int k) {
        // 默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (a - b));
        int index = 0;
        // 前k个数放入小根堆
        for (; index < Math.min(arr.length, k); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        // k+1个数开始放入小根堆，堆顶元素就是数组排好序的位置
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        // 堆中还有k个元素，依次放回数组中
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 6, 5};
        sortedArrDistanceLessK(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

}
