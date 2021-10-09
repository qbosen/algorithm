package top.abosen.leetcode;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

//[352] 将数据流变为多个不相交区间
/* ["SummaryRanges","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals"],[[],[1],[],[3],[],[7],[],[2],[],[6],[]] */
public class DataStreamAsDisjointIntervals {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class SummaryRanges {
        TreeSet<int[]> ts = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
        // -1/10001 会和附近的数据粘连合并
        int[] head = new int[]{-10, -10};
        int[] tail = new int[]{10010, 10010};

        public SummaryRanges() {
            ts.add(head);
            ts.add(tail);
        }

        public void addNum(int val) {
            int[] cur = new int[]{val, val};
            int[] prev = Objects.requireNonNull(ts.floor(cur));
            int[] next = Objects.requireNonNull(ts.ceiling(cur));
            // head tail 保证 prev next 非空
            if ((prev[0] <= val && val <= prev[1]) || (next[0] <= val && val <= next[1])) {
                // 与前后区间重叠
            } else if (prev[1] + 1 == val && next[0] - 1 == val) {
                prev[1] = next[1];
                ts.remove(next);
            } else if (prev[1] + 1 == val) {
                prev[1] = val;
            } else if (next[0] - 1 == val) {
                next[0] = val;
            } else {
                ts.add(cur);
            }
        }

        public int[][] getIntervals() {
            int n = ts.size();
            int[][] res = new int[n-2][2];
            Iterator<int[]> iterator = ts.iterator();
            iterator.next();
            for (int i = 0; i < n-2; i++) {
                res[i] = iterator.next();
            }
            return res;
        }
    }

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
//leetcode submit region end(Prohibit modification and deletion)

}