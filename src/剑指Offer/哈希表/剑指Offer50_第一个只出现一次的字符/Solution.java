package 剑指Offer.哈希表.剑指Offer50_第一个只出现一次的字符;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    // 法1:HashMap<Character, Integer>
    public char firstUniqChar1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (char c : chars) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }

    // 法2: HashMap<Character, Boolean>
    public char firstUniqChar2(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, !map.containsKey(c));
        }
        for (char c : chars) {
            // 第一个将布尔转换为ture的必为次数出现一次的数
            if (map.get(c)) {
                return c;
            }
        }
        return ' ';
    }

    // 法3: LinkedHashMap<Character, Boolean>
    public char firstUniqChar3(String s) {
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, !map.containsKey(c));
        }
        // 利用linkedHashMap的value有序连接,第二轮遍历只用遍历map大大减少二轮遍历次数
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
