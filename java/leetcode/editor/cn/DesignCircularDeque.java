package leetcode.editor.cn;

//[641] 设计循环双端队列
/* ["MyCircularDeque","insertLast","insertLast","insertFront","insertFront","getRear","isFull","deleteLast","insertFront","getFront"],[[3],[1],[2],[3],[4],[],[],[],[4],[]] */
public class DesignCircularDeque {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularDeque {
        int[] array;
        int head, tail;

        public MyCircularDeque(int k) {
            array = new int[k + 1];
            head = 0;
            tail = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) return false;
            array[head] = value;
            head = idx(head + 1);
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) return false;
            tail = idx(tail - 1);
            array[tail] = value;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) return false;
            head = idx(head - 1);
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) return false;
            tail = idx(tail + 1);
            return true;
        }

        public int getFront() {
            if (isEmpty()) return -1;
            return array[idx(head - 1)];
        }

        public int getRear() {
            if (isEmpty()) return -1;
            return array[tail];
        }

        public boolean isEmpty() {
            return head == tail;
        }

        public boolean isFull() {
            return idx(head + 1) == tail;
        }

        private int idx(int i) {
            return (i + array.length) % array.length;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}