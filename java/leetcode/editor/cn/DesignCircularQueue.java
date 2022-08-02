package leetcode.editor.cn;

//[622] 设计循环队列
/* ["MyCircularQueue","enQueue","enQueue","enQueue","enQueue","Rear","isFull","deQueue","enQueue","Rear"],[[3],[1],[2],[3],[4],[],[],[],[4],[]] */
public class DesignCircularQueue {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularQueue {
        int[] array;
        int head, tail, n;

        public MyCircularQueue(int k) {
            n = k + 1;
            array = new int[k + 1];
            head = tail = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            array[head] = value;
            head = (head + 1) % n;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            tail = (tail + 1) % n;
            return true;
        }

        public int Front() {
            if (isEmpty()) return -1;
            return array[tail];

        }

        public int Rear() {
            if (isEmpty()) return -1;
            return array[(head - 1 + n) % n];
        }

        public boolean isEmpty() {
            return head == tail;
        }

        public boolean isFull() {
            return (head + 1) % n == tail;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}