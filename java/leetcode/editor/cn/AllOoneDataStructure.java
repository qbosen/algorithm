package leetcode.editor.cn;

import java.util.*;

//[432] 全 O(1) 的数据结构
/* ["AllOne","inc","inc","getMaxKey","getMinKey","inc","getMaxKey","getMinKey"],[[],["hello"],["hello"],[],[],["leet"],[],[]] */
public class AllOoneDataStructure {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class AllOne {
        private static class Node {
            // 同一个计数的在一个node
            int count;
            Set<String> set;
            Node prev;
            Node next;

            public Node() {
                this.count = -1;
                this.set = new HashSet<>();
                set.add("");
            }

            public Node(int count, String str) {
                this.count = count;
                this.set = new HashSet<>();
                set.add(str);
            }

            public void insertPrev(Node node) {
                Node prevNode = this.prev;
                node.prev = prevNode;
                node.next = this;
                prevNode.next = node;
                this.prev = node;
            }

            public void insertNext(Node node) {
                Node nextNode = this.next;
                node.prev = this;
                node.next = nextNode;
                nextNode.prev = node;
                this.next = node;
            }

            public void addKey(String key) {
                this.set.add(key);
            }

            public void removeKey(String key) {
                this.set.remove(key);
                if (this.set.isEmpty()) {
                    deleteSelf();
                }
            }

            public void deleteSelf() {
                prev.next = next;
                next.prev = prev;
            }
        }

        private final HashMap<String, Node> map;
        private final Node head;
        private final Node tail;

        public AllOne() {
            map = new HashMap<>();
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public void inc(String key) {
            Node node = map.get(key);
            if (node != null) {
                // 下一个刚好大一
                if (node.count + 1 == node.next.count) {
                    node.next.addKey(key);
                    map.put(key, node.next);
                } else {
                    Node newNode = new Node(node.count + 1, key);
                    node.insertNext(newNode);
                    map.put(key, newNode);
                }
                node.removeKey(key);
            } else {
                // 看最小count是否为1
                if (head.next.count == 1) {
                    head.next.addKey(key);
                    map.put(key, head.next);
                } else {
                    Node newNode = new Node(1, key);
                    head.insertNext(newNode);
                    map.put(key, newNode);
                }
            }
        }

        public void dec(String key) {
            Node node = map.get(key);
            if (node == null) return;
            if (node.count == 1) {
                map.remove(key);
            } else if (node.count - 1 == node.prev.count) {
                // 前一个刚好小1
                node.prev.addKey(key);
                map.put(key, node.prev);
            } else {
                Node newNode = new Node(node.count - 1, key);
                node.insertPrev(newNode);
                map.put(key, newNode);
            }

            node.removeKey(key);
        }

        public String getMaxKey() {
            return tail.prev.set.iterator().next();
        }

        public String getMinKey() {
            return head.next.set.iterator().next();
        }
    }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
//leetcode submit region end(Prohibit modification and deletion)

}