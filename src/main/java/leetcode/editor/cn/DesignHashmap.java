package leetcode.editor.cn;

// 706 设计哈希映射
/* ["MyHashMap","put","put","get","get","put","get","remove","get"],[[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2]] */

public class DesignHashmap {
    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashMap {

        private Node[] nodes;

        /** Initialize your data structure here. */
        public MyHashMap() {
            this.nodes = new Node[10000];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int index = calIndex(key);
            if (nodes[index] == null) {
                Node node = new Node(key, value);
                nodes[index] = node;
            } else {
                Node node = findNode(index, key);
                if (node != null) {
                    node.value = value;
                } else {
                    Node head = nodes[index];
                    node = new Node(key, value);
                    Node nextnext = head.next;
                    if (nextnext != null) {
                        nextnext.head = node;
                    }
                    node.next = head.next;
                    node.head = head;
                    head.next = node;
                }
            }
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int index = calIndex(key);
            Node node = findNode(index, key);
            if (node == null) {
                return -1;
            } else {
                return node.value;
            }
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int index = calIndex(key);
            Node node = findNode(index, key);
            if (node == null) {
                return;
            }
            if (node.head == null) {
                if (node.next != null) {
                    node.next.head = null;
                }
                nodes[index] = node.next;
            } else {
                if (node.next != null) {
                    node.next.head = node.head;
                }
                node.head.next = node.next;
            }
        }

        private Node findNode(int index, int key) {
            Node head = nodes[index];
            while (head != null) {
                if (head.key == key) {
                    return head;
                }
                head = head.next;
            }
            return null;
        }

        private int calIndex(int key) {
            if (key >= 0) {
                return key % 10000;
            } else {
                return (-key) % 10000;
            }
        }

        class Node {
            int key;
            int value;
            Node next;
            Node head;
            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}