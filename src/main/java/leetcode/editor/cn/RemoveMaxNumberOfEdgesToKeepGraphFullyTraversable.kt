package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntArray

//1579 保证图可完全遍历
/* 4,[[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]] */

fun main() {
    val result = RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable.Solution()::maxNumEdgesToRemove
    assertThat(result(4, "[[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]".to2DIntArray()), equalTo(2))
    assertThat(result(4, "[[3,1,2],[3,2,3],[1,1,4],[2,1,4]]".to2DIntArray()), equalTo(0))
}

class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class UnionFind(private val n: Int) {
            private val parent = IntArray(n) { it }
            private val size = IntArray(n) { 1 }
            var count = n
                private set

            fun find(i: Int): Int {
                if (parent[i] != i) {
                    parent[i] = find(parent[i])
                }
                return parent[i]
            }

            fun union(i: Int, j: Int): Boolean {
                val ri = find(i)
                val rj = find(j)
                if (ri == rj) return false
                parent[rj] = ri
                size[ri] += size[rj]
                count--
                return true
            }

            fun copy(): UnionFind {
                val uf = UnionFind(n)
                uf.count = count
                for (i in 0 until n) {
                    uf.parent[i] = parent[i]
                    uf.size[i] = size[i]
                }
                return uf
            }

        }

        fun maxNumEdgesToRemove(n: Int, edges: Array<IntArray>): Int {
            val uf = UnionFind(n)
            var sides = 0
            for (i in edges.indices) {
                edges[i][1]--
                edges[i][2]--
                if (edges[i][0] == 3 && uf.union(edges[i][1], edges[i][2])) {
                    sides++
                }
            }
            val ufa = uf
            val ufb = uf.copy()
            edges.forEach { (t, a, b) ->
                if (t == 1 && ufa.union(a, b)) {
                    sides++
                } else if (t == 2 && ufb.union(a, b)) {
                    sides++
                }
            }

            if (ufa.count != 1 || ufb.count != 1) return -1
            return edges.size - sides
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}