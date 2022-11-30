package leetcode.editor.cn;

import java.util.*;

//[895] 最大频率栈
/* ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],[[],[5],[7],[5],[7],[4],[5],[],[],[],[]] */
public class MaximumFrequencyStack {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FreqStack {
        private final PriorityQueue<Node> queue;
        private final Map<Integer, Node> map;
        int counter = 0;

        static class Node {
            final int num;
            final LinkedList<Integer> ids;

            public Node(int num) {
                this.num = num;
                this.ids = new LinkedList<>();
            }
        }

        public FreqStack() {
            Comparator<Node> freqCompare = Comparator.comparing(it -> it.ids.size());
            Comparator<Node> recentCompare = Comparator.comparing(it -> it.ids.getLast());
            queue = new PriorityQueue<>(freqCompare.reversed().thenComparing(recentCompare.reversed()));
            map = new HashMap<>();
        }

        public void push(int val) {
            Node node;
            if (map.containsKey(val)) {
                node = map.get(val);
                queue.remove(node);

            } else {
                node = new Node(val);
                map.put(val, node);
            }
            node.ids.addLast(counter++);
            queue.add(node);
        }

        public int pop() {
            Node node = queue.poll();
            node.ids.removeLast();
            if (node.ids.isEmpty()) {
                map.remove(node.num);
            } else {
                queue.add(node);
            }
            return node.num;
        }
    }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
//leetcode submit region end(Prohibit modification and deletion)

}