package leetcode.editor.cn;

// 705 设计哈希集合
/* ["MyHashSet","add","add","contains","contains","add","contains","remove","contains"],[[],[1],[2],[1],[3],[2],[2],[2],[2]] */

import java.util.LinkedList;

public class DesignHashset {
    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashSet {
        private static final int BASE = 769;
        private final LinkedList<Integer>[] data;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            data = new LinkedList[BASE];
        }

        public void add(int key) {
            LinkedList<Integer> bucket = get(key);
            for (Integer num : bucket) {
                if (num == key) return;
            }
            bucket.addLast(key);
        }

        public void remove(int key) {
            LinkedList<Integer> bucket = get(key);
            bucket.removeIf(next -> next == key);
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            LinkedList<Integer> bucket = get(key);
            for (Integer num : bucket) {
                if (num == key) return true;
            }
            return false;
        }

        private LinkedList<Integer> get(int num) {
            int idx = hash(num);
            if (data[idx] == null) {
                data[idx] = new LinkedList<Integer>();
            }
            return data[idx];
        }

        private int hash(int num) {
            return num % BASE;
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}