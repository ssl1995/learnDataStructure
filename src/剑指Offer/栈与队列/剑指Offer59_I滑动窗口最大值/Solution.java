package 剑指Offer.栈与队列.剑指Offer59_I滑动窗口最大值;

import java.util.LinkedList;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 1) {
            return new int[]{};
        }
        // 双端队列:[对头,...,队尾],存区间下标
        LinkedList<Integer> dequeue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // 队头,永远只存最大值,队头后面永远元素都比队头小
            while (!dequeue.isEmpty() && nums[i] >= nums[dequeue.peekLast()]) {
                dequeue.pollLast();
            }
            dequeue.addLast(i);
            // 队列长度:队头长度=i-k,队头下标已过窗口长度,移除队头下标
            if (dequeue.peekFirst() == i - k) {
                dequeue.pollFirst();
            }
            // 遍历下标只要越过k-1,每次都要记录一个最大值
            if (i >= k - 1) {
                res[index++] = nums[dequeue.peekFirst()];
            }
        }
        return res;
    }
}
