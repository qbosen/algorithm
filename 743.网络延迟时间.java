/*
 * @lc app=leetcode.cn id=743 lang=java
 *
 * [743] 网络延迟时间
 *
 * https://leetcode-cn.com/problems/network-delay-time/description/
 *
 * algorithms
 * Medium (48.45%)
 * Likes:    357
 * Dislikes: 0
 * Total Accepted:    40.6K
 * Total Submissions: 81.1K
 * Testcase Example:  '[[2,1,1],[2,3,1],[3,4,1]]\n4\n2'
 *
 * 有 n 个网络节点，标记为 1 到 n。
 * 
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点，
 * wi 是一个信号从源节点传递到目标节点的时间。
 * 
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * times[i].length == 3
 * 1 i, vi 
 * ui != vi
 * 0 i 
 * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
 * 
 * 
 */

// @lc code=start
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<int[]>();
        }
        for (int[] t : times) {
            int x = t[0] - 1, y = t[1] - 1;
            g[x].add(new int[]{y, t[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        pq.offer(new int[]{0, k - 1});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int time = p[0], x = p[1];
            if (dist[x] < time) {
                continue;
            }
            for (int[] e : g[x]) {
                int y = e[0], d = dist[x] + e[1];
                if (d < dist[y]) {
                    dist[y] = d;
                    pq.offer(new int[]{d, y});
                }
            }
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }
}

// @lc code=end

