package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntArray
import kotlin.collections.ArrayList

//1631 最小体力消耗路径
/* [[1,2,2],[3,8,2],[5,3,5]] */

fun main() {
    val result = PathWithMinimumEffort.Solution()::minimumEffortPath
    assertThat(result("[[1,2,2],[3,8,2],[5,3,5]]".to2DIntArray()), equalTo(2))
    assertThat(result("[[1,2,3],[3,8,4],[5,3,5]]".to2DIntArray()), equalTo(1))
    assertThat(result("[[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]".to2DIntArray()), equalTo(0))
}

class PathWithMinimumEffort {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class UnionFind(private val n: Int) {
            val parent = IntArray(n) { it }
            val size = IntArray(n) { 1 }
            var count = n
                private set

            fun find(i: Int): Int {
                if (i != parent[i]) {
                    parent[i] = find(parent[i])
                }
                return parent[i]
            }

            fun isConnected(i: Int, j: Int): Boolean = find(i) == find(j)

            fun union(i: Int, j: Int): Boolean {
                val ri = find(i)
                val rj = find(j)
                if (ri == rj) return false
                parent[rj] = ri
                size[ri] += size[rj]
                count--
                return true
            }
        }

        fun minimumEffortPath(heights: Array<IntArray>): Int {
            val m = heights.size
            val n = heights[0].size
            val total = m * n
            val capacity = (total * 2 / 0.75 + 1).toInt()
            val edges = ArrayList<IntArray>(capacity)

            for (i in 0 until m) {
                for (j in 0 until n) {
                    val idx = i * n + j
                    if (i < m - 1) edges.add(intArrayOf(idx, idx + n, Math.abs(heights[i][j] - heights[i + 1][j])))
                    if (j < n - 1) edges.add(intArrayOf(idx, idx + 1, Math.abs(heights[i][j] - heights[i][j + 1])))
                }
            }

            edges.sortBy { it[2] }
            val uf = UnionFind(total)
            var cost = 0

            for (edge in edges) {
                if (uf.isConnected(0, total - 1)) break
                if (uf.union(edge[0], edge[1])) cost = edge[2]
            }

            return cost
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}