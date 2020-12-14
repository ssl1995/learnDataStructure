package ssl.heap.leetcode;


import java.util.PriorityQueue;

/**
 * @Author ssl
 * @Date 2020/12/13 16:06
 * @Description 力扣215. 数组中的第K个最大元素
 */
public class LC215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (!queue.isEmpty() && queue.peek() < nums[i]) {
                queue.remove();
                queue.add(nums[i]);
            }
        }

        return queue.peek();
    }
}
