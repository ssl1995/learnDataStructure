package codingInterview.哈希表.剑指Offer48_最长无重复子串长度;

public class Solution {
    // 难理解,多debug记录每个变量的含义
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        // 初始化5个变量:chars,map,len,curLen,pre
        char[] chars = s.toCharArray();
        // map数组,下标为chars[i],值为当前元素最近出现的位置,初试化为-1
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
        // pre表示当前元素与上一个当前元素之间,最长无重复子串的开始位置的前一个位置
        int pre = -1;
        // 记录最长长度
        int len = 0;
        // 记录当前索引和pre之间的距离
        int curLen;
        for (int i = 0; i < chars.length; i++) {
            pre = Math.max(pre, map[chars[i]]);
            curLen = i - pre;
            len = Math.max(len, curLen);
            // 更新当前元素上一次出现的位置进map中
            map[chars[i]] = i;
        }
        return len;
    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        Solution solution = new Solution();
        int maxLen = solution.lengthOfLongestSubstring(s);
        System.out.println(maxLen);
    }
}
