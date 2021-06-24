import java.util.Map;

/*
 * @lc app=leetcode.cn id=149 lang=java
 *
 * [149] 直线上最多的点数
 *
 * https://leetcode-cn.com/problems/max-points-on-a-line/description/
 *
 * algorithms
 * Hard (25.68%)
 * Likes:    281
 * Dislikes: 0
 * Total Accepted:    29.7K
 * Total Submissions: 103.9K
 * Testcase Example:  '[[1,1],[2,2],[3,3]]'
 *
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：3
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * points[i].length == 2
 * -10^4 i, yi 
 * points 中的所有点 互不相同
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {
        int res = 1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            // 从当前点出发的直线 经过点的最大数量
            map.clear();
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                int a = x1 - x2, b = y1 - y2;
                // 点斜式
                String k;
                if (a == 0) {
                    k = "0";
                } else if (b == 0) {
                    k = "inf";
                } else {
                    int gcd = gcd(a, b);
                    k = (a / gcd) + "/" + (b / gcd);
                }
                int count = map.compute(k, (_k, v) -> v == null ? 2 : v + 1);
                res = Math.max(res, count);
            }
        }
        return res;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
// @lc code=end
