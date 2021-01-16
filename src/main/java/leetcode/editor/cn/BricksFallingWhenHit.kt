package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray
import util.to2DIntArray

// 803 打砖块
/* [[1,0,0,0],[1,1,1,0]],[[1,0]] */

fun main() {
    val result = BricksFallingWhenHit.Solution()::hitBricks
    assertThat(
        result("[[1,0,0,0],[1,1,1,0]]".to2DIntArray(), "[[1,0]]".to2DIntArray()),
        equalTo("[2]".to1DIntArray())
    )
    assertThat(
        result("[[1,0,0,0],[1,1,0,0]]".to2DIntArray(), "[[1,1],[1,0]]".to2DIntArray()),
        equalTo("[0,0]".to1DIntArray())
    )
    assertThat(
        result("[[1],[1],[1],[1],[1]]".to2DIntArray(), "[[3,0],[4,0],[1,0],[2,0],[0,0]]".to2DIntArray()),
        equalTo("[1,0,1,0,0]".to1DIntArray())
    )
    assertThat(
        result("[[1,0,1],[1,1,1]]".to2DIntArray(), "[[0,0],[0,2],[1,1]]".to2DIntArray()),
        equalTo("[0,3,0]".to1DIntArray())
    )
}

class BricksFallingWhenHit {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class UnionFind(n: Int) {
            private val parent = IntArray(n) { it }
            private val size = IntArray(n) { 1 }

            // 路径压缩没有维护size集合，size维持每个不相交集合根结点正确
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
                parent[ri] = rj
                size[rj] += size[ri]
            }

            fun size(i: Int) = size[find(i)]
        }

        fun hitBricks(grid: Array<IntArray>, hits: Array<IntArray>): IntArray {
            val m = grid.size
            val n = grid[0].size
            val proof = m * n // 屋顶
            val uf = UnionFind(proof + 1)
            fun idx(i: Int, j: Int) = i * n + j
            // 倒序填补
            // 打碎hits
            val hitBoolean = BooleanArray(hits.size)
            for (i in hits.indices) {
                val x = hits[i][0]
                val y = hits[i][1]
                if (grid[x][y] == 1) {
                    hitBoolean[i] = true
                    grid[x][y] = 0
                }
            }

            // 连通屋顶
            for (j in 0 until n) {
                if (grid[0][j] == 1) uf.union(j, proof)
            }
            for (i in 1 until m) {
                for (j in 0 until n) {
                    if (grid[i][j] == 1) {
                        if (grid[i - 1][j] == 1) //上
                            uf.union(idx(i, j), idx(i - 1, j))
                        if (j > 0 && grid[i][j - 1] == 1) //左
                            uf.union(idx(i, j), idx(i, j - 1))
                    }
                }
            }
            // 回补，记录增量
            val res = IntArray(hits.size)
            val directions = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
            for (i in hits.lastIndex downTo 0) {
                val x = hits[i][0]
                val y = hits[i][1]
                // 没有击碎
                if (!hitBoolean[i]) continue
                val origin = uf.size(proof)
                if (x == 0) uf.union(y, proof)
                // 四个方向
                for (dir in directions) {
                    val nx = x + dir.first
                    val ny = y + dir.second
                    if (nx in 0 until m && ny in 0 until n && grid[nx][ny] == 1)
                        uf.union(idx(x, y), idx(nx, ny))
                }
                val current = uf.size(proof)
                res[i] = Math.max(0, current - origin - 1)
                // 回补
                grid[x][y] = 1
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}