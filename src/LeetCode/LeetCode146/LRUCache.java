package LeetCode.LeetCode146;

import java.util.HashMap;

/*
    LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
    int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
    void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 */
public class LRUCache {

    private HashMap<Integer, DoubleNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DoubleNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DoubleNode();
        tail = new DoubleNode();
        // 创建伪头部和伪尾部，减少添加和删除的逻辑
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        // 1.获取get元素
        DoubleNode node = cache.get(key);
        // 2.get元素不存就返回-1
        if (node == null) {
            return -1;
        }
        // 3.get元素就移动至头部，规定常用元素移动至头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        // 1.获取put元素
        DoubleNode node = cache.get(key);
        // 2.put元素不存在
        if (node == null) {
            // 生成它
            DoubleNode nowNode = new DoubleNode(key, value);
            // 放进cache
            cache.put(key, nowNode);
            // 添加进头部
            addToHead(nowNode);
            // 长度++
            size++;
            // 判断是否超过指定长度
            if (size > capacity) {
                DoubleNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            // 3.node存在就更新value，然后移动至头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DoubleNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private DoubleNode removeTail() {
        DoubleNode del = tail.pre;
        removeNode(del);
        return del;
    }

    private void removeNode(DoubleNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(DoubleNode node) {
        removeNode(node);
        addToHead(node);
    }

    class DoubleNode {
        int key;
        int value;
        DoubleNode pre;
        DoubleNode next;

        DoubleNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        DoubleNode() {

        }
    }
}