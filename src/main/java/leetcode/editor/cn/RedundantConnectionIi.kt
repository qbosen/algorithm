package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to2DIntArray

// 685 冗余连接 II
/* [[1,2],[1,3],[2,3]] */

fun main() {
    val result = RedundantConnectionIi.Solution()::findRedundantDirectedConnection
    assertThat(result("[[1,2],[1,3],[2,3]]".to2DIntArray()), equalTo(intArrayOf(2, 3)))
    assertThat(result("[[1,2], [2,3], [3,4], [4,1], [1,5]]".to2DIntArray()), equalTo(intArrayOf(4, 1)))
}

class RedundantConnectionIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findRedundantDirectedConnection(edges: Array<IntArray>): IntArray {
            val uf = UnionFind(edges.size + 1)
            val parent = IntArray(edges.size + 1) { it }
            var conflict = -1
            var cycle = -1

            for (i in edges.indices) {
                val edge = edges[i]
                val (a, b) = edge
                if (parent[b] != b) {   // a是b的parent，但是b已经有parent了，冲突出现,可能有环
                    conflict = i
                } else {
                    parent[b] = a
                    if (uf.find(a) == uf.find(b)) {   // 环出现
                        cycle = i
                    } else {
                        uf.union(a, b)
                    }
                }
            }
            return when {
                conflict < 0 -> edges[cycle]
                cycle >= 0 -> intArrayOf(parent[edges[conflict][1]], edges[conflict][1])
                else -> edges[conflict]
            }
        }

    }

    class UnionFind(n: Int) {
        private val ancestor: IntArray = IntArray(n) { it }

        fun union(i: Int, j: Int) {
            ancestor[find(i)] = find(j)
        }

        fun find(i: Int): Int {
            if (ancestor[i] != i) {
                ancestor[i] = find(ancestor[i])
            }
            return ancestor[i]
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}