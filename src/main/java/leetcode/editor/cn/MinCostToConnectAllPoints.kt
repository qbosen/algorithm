package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntArray

//1584 连接所有点的最小费用
/* [[0,0],[2,2],[3,10],[5,2],[7,0]] */

fun main() {
    val result = MinCostToConnectAllPoints.Solution()::minCostConnectPoints
    assertThat(result("[[0,0],[2,2],[3,10],[5,2],[7,0]]".to2DIntArray()), equalTo(20))
    assertThat(result("[[0,0],[1,1],[1,0],[-1,1]]".to2DIntArray()), equalTo(4))
    assertThat(result("[[-1000000,-1000000],[1000000,1000000]]".to2DIntArray()), equalTo(4000000))
    assertThat(result("[[0,0]]".to2DIntArray()), equalTo(0))
}

class MinCostToConnectAllPoints {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun minCostConnectPoints(points: Array<IntArray>): Int {
            val n = points.size
            if (n <= 1) return 0
            var res = 0
            // 邻接矩阵
            val distance = Array(n) { IntArray(n) }
            for (i in 0 until n) {
                for (j in i + 1 until n) {
                    val dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])
                    distance[i][j] = dist
                    distance[j][i] = dist
                }
            }
            // 是否在顶点集合v中
            val v = BooleanArray(n){true}
            // vi 到 v_new的最近距离
            val cost = IntArray(n) { Int.MAX_VALUE }

            // 随机添加第一个节点 到 v_new
            val start = 0
            v[start] = false
            for (i in 0 until n) {
                if(i == start) continue
                cost[i] = distance[i][start]
            }

            // 添加剩下的n-1个节点
            for(i in 1 until n){
                // 找出离v_new最近的v中节点
                var minIdx = -1
                var minVal = Int.MAX_VALUE
                for(j in 0 until n){
                    if(v[j] && cost[j] < minVal){
                        minIdx = j
                        minVal = cost[j]
                    }
                }
                // 把该节点加入v_new
                res += minVal
                v[minIdx] = false
                cost[minIdx] = -1
                // 更新v中的costs
                for (j in 0 until n) {
                    if(v[j] && distance[j][minIdx] < cost[j]){
                        cost[j] = distance[j][minIdx]
                    }
                }
            }

            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}