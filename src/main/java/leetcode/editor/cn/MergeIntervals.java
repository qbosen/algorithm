package leetcode.editor.cn;
// 合并区间
// 56
// [[1,3],[2,6],[8,10],[15,18]]

import util.IntUtil;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public static void run(Solution solution, String expect, String intervals) {
        int[][] intervals_ = IntUtil.parse2DIntArray(intervals);
        int[][] result = solution.merge(intervals_);
        System.out.println(expect + "=" + Arrays.deepToString(result));
    }

    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        run(solution, "[[1,6],[8,10],[15,18]]", "[[1,3],[2,6],[8,10],[15,18]]");
        run(solution, "[[1,5]]", "[[1,4],[4,5]]");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) return intervals;
            Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
            int count = 0;

            int start = intervals[0][0];
            int maxR = intervals[0][1];
            for (int[] interval : intervals) {
                if (maxR < interval[0]) {
                    intervals[count++] = new int[]{start, maxR};
                    start = interval[0];
                    maxR = interval[1];
                    continue;
                }
                maxR = Math.max(maxR, interval[1]);
            }
            intervals[count++] = new int[]{start, maxR};

            return Arrays.copyOf(intervals, count);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}