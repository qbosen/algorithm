package top.abosen.leetcode;

import java.util.HashMap;
import java.util.Map;

//447 回旋镖的数量
/* [[0,0],[1,0],[2,0]] */
public class NumberOfBoomerangs {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int n = points.length;
            int ans = 0;
            if (n < 3) return ans;

            for (int i = 0; i < n; i++) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    int x = points[i][0] - points[j][0], y = points[i][1] - points[j][1];
                    int dist = x * x + y * y;
                    map.compute(dist, (k, v) -> v == null ? 1 : v + 1);
                }
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    Integer count = entry.getValue();
                    ans += count * (count - 1);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}