package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntArray

//1319 连通网络的操作次数
/* 4,[[0,1],[0,2],[1,2]] */

fun main() {
    val result = NumberOfOperationsToMakeNetworkConnected.Solution()::makeConnected
    assertThat(result(4, "[[0,1],[0,2],[1,2]]".to2DIntArray()), equalTo(1))
    assertThat(result(6, "[[0,1],[0,2],[0,3],[1,2],[1,3]]".to2DIntArray()), equalTo(2))
}

class NumberOfOperationsToMakeNetworkConnected {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class UnionFind(private val n: Int) {
            val parent = IntArray(n) { it }
            val size = IntArray(n) { 1 }
            var count = n

            fun find(i: Int): Int {
                if (parent[i] != i) {
                    parent[i] = find(parent[i])
                }
                return parent[i]
            }

            fun union(i: Int, j: Int) {
                val ri = find(i)
                val rj = find(j)
                if (ri == rj) return
                parent[rj] = ri
                size[ri] += size[rj]
                count--
            }
        }

        fun makeConnected(n: Int, connections: Array<IntArray>): Int {
            if (connections.size < n - 1) return -1
            val uf = UnionFind(n)
            for ((i, j) in connections) {
                uf.union(i, j)
            }
            return uf.count - 1
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}