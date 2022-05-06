package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[933] 最近的请求次数
/* ["RecentCounter","ping","ping","ping","ping"],[[],[1],[100],[3001],[3002]] */
public class NumberOfRecentCalls {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RecentCounter {
        private Deque<Integer> deque;

        public RecentCounter() {
            deque = new ArrayDeque<>();
        }

        public int ping(int t) {
            deque.addLast(t);
            int bound = t - 3000;
            while (!deque.isEmpty() && deque.peekFirst() < bound) {
                deque.pollFirst();
            }
            return deque.size();
        }
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
//leetcode submit region end(Prohibit modification and deletion)

}