package codingInterview.数组与字符串.剑指Offer61_扑克牌中的顺子;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // 从一幅扑克牌中抽出5张牌,判断是否是顺子
    public boolean isStraight(int[] nums) {
        // set判断是否有重复的数
        Set<Integer> set = new HashSet<>();
        // 扑克牌范围[0,13],初始化min=13,max=0
        int min = 13, max = 0;
        for (int num : nums) {
            // 1.如果是大小王,就跳过
            if (num == 0) {
                continue;
            } else {
                // 2.不是大小王,先判断是否有重复数字
                if (set.contains(num)) {
                    return false;
                } else {
                    // 3.没有重复数字,再添加进set,判断最大值,最小值
                    set.add(num);
                    min = Math.min(min, num);
                    max = Math.max(max, num);
                }
            }
        }
        // 4.判断顺子依据:max-min<5必为顺子
        return max - min < 5;
    }
}
