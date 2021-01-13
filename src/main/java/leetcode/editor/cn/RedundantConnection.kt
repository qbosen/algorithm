package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray
import util.to2DIntArray

//684 冗余连接
/* [[1,2],[1,3],[2,3]] */

fun main() {
    val result = RedundantConnection.Solution()::findRedundantConnection
    assertThat(result("[[1,2],[1,3],[2,3]]".to2DIntArray()), equalTo("[2,3]".to1DIntArray()))
    assertThat(result("[[1,2], [2,3], [3,4], [1,4], [1,5]]".to2DIntArray()), equalTo("[1,4]".to1DIntArray()))
}

class RedundantConnection {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findRedundantConnection(edges: Array<IntArray>): IntArray {
            val uf = IntArray(edges.size + 1) { it }
            fun find(i: Int): Int {
                if (uf[i] != i) {
                    uf[i] = find(uf[i])
                }
                return uf[i]
            }

            fun union(a: Int, b: Int) {
                uf[find(a)] = find(b)
            }

            edges.forEach { (a, b) ->
                if (find(a) != find(b)) union(a, b)
                else return intArrayOf(a, b)
            }
            return IntArray(0)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}