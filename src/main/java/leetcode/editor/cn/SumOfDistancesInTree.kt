package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray
import util.to2DIntArray
import java.util.*
import kotlin.collections.ArrayList


// 树中距离之和
// 834
/* 6,[[0,1],[0,2],[2,3],[2,4],[2,5]] */

fun main() {
    val result = SumOfDistancesInTree.Solution()::sumOfDistancesInTree
    assertThat(result(6, "[[0,1],[0,2],[2,3],[2,4],[2,5]]".to2DIntArray()), equalTo("[8,12,6,10,10,10]".to1DIntArray()))
}

class SumOfDistancesInTree {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun sumOfDistancesInTree(N: Int, edges: Array<IntArray>): IntArray? {
            var graph = ArrayList<ArrayList<Int>>()
            val ans = IntArray(N)
            val sz = IntArray(N)
            val dp = IntArray(N)
            fun dfs(u: Int, f: Int) {
                sz[u] = 1
                dp[u] = 0
                for (v in graph[u]) {
                    if (v == f) {
                        continue
                    }
                    dfs(v, u)
                    dp[u] += dp[v] + sz[v]
                    sz[u] += sz[v]
                }
            }

            fun dfs2(u: Int, f: Int) {
                ans[u] = dp[u]
                for (v in graph[u]) {
                    if (v == f) {
                        continue
                    }
                    val pu = dp[u]
                    val pv = dp[v]
                    val su = sz[u]
                    val sv = sz[v]
                    dp[u] -= dp[v] + sz[v]
                    sz[u] -= sz[v]
                    dp[v] += dp[u] + sz[u]
                    sz[v] += sz[u]
                    dfs2(v, u)
                    dp[u] = pu
                    dp[v] = pv
                    sz[u] = su
                    sz[v] = sv
                }
            }


            graph = ArrayList()
            for (i in 0 until N) {
                graph.add(ArrayList())
            }
            for (edge in edges) {
                val u = edge[0]
                val v = edge[1]
                graph[u].add(v)
                graph[v].add(u)
            }
            dfs(0, -1)
            dfs2(0, -1)
            return ans
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}