package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DStringList
import util.toStringList

//959 由斜杠划分区域
/* [",/","/,"] */

fun main() {
    val result = RegionsCutBySlashes.Solution()::regionsBySlashes
    assertThat(result("""[" /","/ "]""".toStringList().toTypedArray()), equalTo(2))
    assertThat(result("""[" /","  "]""".toStringList().toTypedArray()), equalTo(1))
    assertThat(result("""["\\/","/\\"]""".toStringList().toTypedArray()), equalTo(4))
    assertThat(result("""["/\\","\\/"]""".toStringList().toTypedArray()), equalTo(5))
}

class RegionsCutBySlashes {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class UnionFind(n: Int) {
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

        fun regionsBySlashes(grid: Array<String>): Int {
            val n = grid.size
            val uf = UnionFind(4 * n * n)
            for (i in 0 until n) {
                for (j in 0 until n) {
                    val idx = 4 * (i * n + j)
                    when (grid[i][j]) {
                        ' ' -> {
                            uf.union(idx, idx + 1)
                            uf.union(idx, idx + 2)
                            uf.union(idx, idx + 3)
                        }
                        '/' -> {
                            uf.union(idx, idx + 3)
                            uf.union(idx + 1, idx + 2)
                        }
                        '\\' -> {
                            uf.union(idx, idx + 1)
                            uf.union(idx + 2, idx + 3)
                        }
                    }
                    // 方块格子间的连通性
                    if (i < n - 1) {
                        uf.union(idx + 2, idx + 4 * n)
                    }
                    if (j < n - 1) {
                        uf.union(idx + 1, idx + 4 + 3)
                    }
                }
            }
            return uf.count
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}