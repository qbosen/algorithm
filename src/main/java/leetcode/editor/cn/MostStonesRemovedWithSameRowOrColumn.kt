package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntArray

//947 移除最多的同行或同列石头
/* [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]] */

fun main() {
    val result = MostStonesRemovedWithSameRowOrColumn.Solution()::removeStones
    assertThat(result("[[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]".to2DIntArray()), equalTo(5))
    assertThat(result("[[0,0],[0,2],[1,1],[2,0],[2,2]]".to2DIntArray()), equalTo(3))
    assertThat(result("[[0,0]]".to2DIntArray()), equalTo(0))
}

class MostStonesRemovedWithSameRowOrColumn {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class UnionFind {
            private val parent = HashMap<Int, Int>()
            var count = 0
                private set

            fun find(i: Int): Int {
                if (parent[i] == null) {
                    parent[i] = i
                    count++
                }
                if (i != parent[i]) {
                    parent[i] = find(parent[i]!!)
                }
                return parent[i]!!
            }

            fun union(i: Int, j: Int) {
                val a = find(i)
                val b = find(j)
                if (a == b) return
                parent[a] = b
                count--
            }
        }

        fun removeStones(stones: Array<IntArray>): Int {
            val uf = UnionFind()
            stones.forEach { (i, j) -> uf.union(i + 10001, j) }
            return stones.size - uf.count
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}