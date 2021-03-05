package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//232 用栈实现队列
/* ["MyQueue","push","push","peek","pop","empty"],[[],[1],[2],[],[],[]] */
public class ImplementQueueUsingStacks {

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {
        private final Deque<Integer> in;
        private final Deque<Integer> out;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            in = new LinkedList<>();
            out = new LinkedList<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            in.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return out.isEmpty() && in.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}