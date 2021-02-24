package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

// 765 情侣牵手
/* [0,2,1,3] */

fun main() {
    val result = CouplesHoldingHands.Solution()::minSwapsCouples
    assertThat(result("[0,2,1,3]".to1DIntArray()), equalTo(1))
    assertThat(result("[3,2,0,1]".to1DIntArray()), equalTo(0))
}

class CouplesHoldingHands {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class UnionFind(val n: Int) {
            val parent = IntArray(n) { it }
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
                parent[ri] = rj
                count--
            }
        }

        fun minSwapsCouples(row: IntArray): Int {
            val n = row.size / 2
            val uf = UnionFind(n)
            for (i in 0 until n) {
                uf.union(row[i * 2] / 2, row[i * 2 + 1] / 2)
            }
            return n - uf.count
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}