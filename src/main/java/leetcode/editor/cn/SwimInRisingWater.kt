package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntArray


// 778 水位上升的泳池中游泳
/* [[0,2],[1,3]] */

fun main() {
    val result = SwimInRisingWater.Solution()::swimInWater
    assertThat(result("[[0,2],[1,3]]".to2DIntArray()), equalTo(3))
    assertThat(
        result("[[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]".to2DIntArray()),
        equalTo(16)
    )
}

class SwimInRisingWater {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private class UnionFind(private val n: Int) {
            val parent = IntArray(n) { it }
            val size = IntArray(n) { 1 }
            var count = n
            fun find(i: Int): Int {
                if (parent[i] != i)
                    parent[i] = find(parent[i])
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

            fun isConnected(i: Int, j: Int): Boolean = find(i) == find(j)
        }

        fun swimInWater(grid: Array<IntArray>): Int {
            val N = grid.size

            val len = N * N
            val index = IntArray(len)
            for (i in 0 until N) {
                for (j in 0 until N) {
                    index[grid[i][j]] = i * N + j
                }
            }

            val direction = arrayOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
            val unionFind = UnionFind(len)
            for (i in 0 until len) {
                val x: Int = index[i] / N
                val y: Int = index[i] % N
                for ((dx, dy) in direction) {
                    val nx = x + dx
                    val ny = y + dy
                    if (nx in 0 until N && ny in 0 until N && grid[nx][ny] <= i) {
                        unionFind.union(index[i], nx * N + ny)
                    }
                    if (unionFind.isConnected(0, len - 1)) {
                        return i
                    }
                }
            }
            return -1

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}