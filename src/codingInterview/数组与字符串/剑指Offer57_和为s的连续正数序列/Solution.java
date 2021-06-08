package codingInterview.数组与字符串.剑指Offer57_和为s的连续正数序列;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[][] findContinuousSequence(int target) {
        // 1.滑动窗口左右指针只能往后移,并且是左闭右开[left,right)
        // 因为是正数连续序列,初始化为[1,1)左闭右开,sum=0
        int left = 1;
        int right = 1;
        int sum = 0;
        // 结果集:不知道返回值二维数组有多少个,所以暂时用链表存储
        List<int[]> list = new ArrayList<>();
        // 遍历:left<=target/2
        // 因为正数连续,如果left过了一半,left+(left+1)必超过target
        while (left <= (target / 2)) {
            if (sum < target) {// 窗口和小了
                // sum加上右指针值,再右指针后移
                sum += right;
                right++;
            } else if (sum > target) {// 窗口和大了
                // sum先减左指针值,再左指针后移
                sum -= left;
                left++;
            } else {// 窗口和=target
                // 窗口左闭右开[left,right),长度=right-left
                int[] temp = new int[right - left];
                for (int i = left; i < right; i++) {
                    temp[i - left] = i;
                }
                list.add(temp);
                // 窗口和=target,sum减去左指针,左指针后移,右指针不动
                sum -= left;
                left++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
