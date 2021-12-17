package top.abosen.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//[1610] 可见点的最大数目
/* [[2,1],[2,2],[3,3]],90,[1,1] */
public class MaximumNumberOfVisiblePoints {
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfVisiblePoints().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
            int x = location.get(0), y = location.get(1);
            List<Double> degrees = new ArrayList<>();
            double pi = Math.PI, r = angle * pi / 180.0;

            int coincide = 0;
            for (List<Integer> point : points) {
                int a = point.get(0), b = point.get(1);
                if (a == x && b == y) {
                    coincide++;
                    continue;
                }
                degrees.add(Math.atan2(b - y, a - x));
            }
            Collections.sort(degrees);
            // 范围在-pi~pi，增加一圈，映射到-pi~3pi 解决连续性问题 即跨坐标轴的问题
            int n = degrees.size();
            for (int i = 0; i < n; i++) {
                degrees.add(degrees.get(i) + 2 * pi);
            }

            int maxCnt = 0;
            int right = 0;
            for (int i = 0; i < n; i++) {
                double bound = degrees.get(i) + r;
                while (right < degrees.size() && degrees.get(right) <= bound) {
                    right++;
                }
                maxCnt = Math.max(maxCnt, right - i);
            }
            return maxCnt + coincide;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}