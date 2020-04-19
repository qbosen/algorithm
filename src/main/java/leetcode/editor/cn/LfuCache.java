package leetcode.editor.cn;
// LFU缓存
// 460
// ["LFUCache","put","put","get","put","get","get","put","get","get","get"]
// [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]

import java.util.*;

import static org.junit.Assert.assertEquals;

public class LfuCache {

    public static void main(String[] args) {
        LFUCache cache = new LfuCache().new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        assertEquals(-1, cache.get(2));       // 返回 -1 (未找到key 2)
        assertEquals(3, cache.get(3));       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        assertEquals(-1, cache.get(1));       // 返回 -1 (未找到 key 1)
        assertEquals(3, cache.get(3));       // 返回 3
        assertEquals(4, cache.get(4));       // 返回 4
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {
        Map<Integer, Node> cache;
        Map<Integer, LinkedNodeList> freqMap;
        int size;
        int capacity;
        int minFreq;

        public LFUCache(int capacity) {
            cache = new HashMap<> (capacity);
            freqMap = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }
            freqInc(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            Node node = cache.get(key);
            if (node != null) {
                node.value = value;
                freqInc(node);
            } else {
                if (size == capacity) {
                    LinkedNodeList minFreqLinkedList = freqMap.get(minFreq);
                    cache.remove(minFreqLinkedList.tail.prev.key);
                    minFreqLinkedList.removeNode(minFreqLinkedList.tail.prev); // 这里不需要维护min, 因为下面add了newNode后min肯定是1.
                    size--;
                }
                Node newNode = new Node(key, value);
                cache.put(key, newNode);
                LinkedNodeList linkedList = freqMap.get(1);
                if (linkedList == null) {
                    linkedList = new LinkedNodeList();
                    freqMap.put(1, linkedList);
                }
                linkedList.addNode(newNode);
                size++;
                minFreq = 1;
            }
        }

        void freqInc(Node node) {
            // 从原freq对应的链表里移除, 并更新min
            int freq = node.freq;
            LinkedNodeList linkedList = freqMap.get(freq);
            linkedList.removeNode(node);
            if (freq == minFreq && linkedList.head.next == linkedList.tail) {
                minFreq = freq + 1;
            }
            // 加入新freq对应的链表
            node.freq++;
            linkedList = freqMap.get(freq + 1);
            if (linkedList == null) {
                linkedList = new LinkedNodeList();
                freqMap.put(freq + 1, linkedList);
            }
            linkedList.addNode(node);
        }
    }

    class Node {
        int key;
        int value;
        int freq = 1;
        Node prev;
        Node next;

        public Node() {}

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class LinkedNodeList {
        Node head;
        Node tail;

        public LinkedNodeList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        void addNode(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}