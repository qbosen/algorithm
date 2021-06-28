import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=815 lang=java
 *
 * [815] 公交路线
 *
 * https://leetcode-cn.com/problems/bus-routes/description/
 *
 * algorithms
 * Hard (33.71%)
 * Likes:    205
 * Dislikes: 0
 * Total Accepted:    20.8K
 * Total Submissions: 49.6K
 * Testcase Example:  '[[1,2,7],[3,6,7]]\n1\n6'
 *
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 * 
 * 
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1
 * -> ... 这样的车站路线行驶。
 * 
 * 
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 * 
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。 
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target =
 * 12
 * 输出：-1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 .
 * 1 
 * routes[i] 中的所有值 互不相同
 * sum(routes[i].length) 
 * 0 
 * 0 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        // 路线数，即公交编号
        int n = routes.length;
        // 路线网络，每条边费用1
        boolean[][] edge = new boolean[n][n];
        // 公交站 和经过他的路线
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int site : routes[i]) {
                List<Integer> list = map.getOrDefault(site, new ArrayList<>());
                for (int j : list) {
                    edge[i][j] = edge[j][i] = true;
                }
                list.add(i);
                map.put(site, list);
            }
        }
        // 起点 或 终点 没有公交线路
        if (!map.containsKey(source) || !map.containsKey(target)) {
            return -1;
        }

        // 从source 到 i号线 的费用
        int[] dis = new int[n];
        Queue<Integer> queue = new ArrayDeque<>();
        for (Integer bus : map.get(source)) {
            dis[bus] = 1;
            queue.offer(bus);
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int y = 0; y < n; y++) {
                // 找到 可以从 x 换乘的所有线路 bfs
                // dis[y]!=0 已经遍历
                if (edge[x][y] && dis[y] == 0) {
                    dis[y] = dis[x] + 1;
                    queue.offer(y);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (Integer bus : map.get(target)) {
            if (dis[bus] != 0) {
                res = Math.min(res, dis[bus]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
// @lc code=end

