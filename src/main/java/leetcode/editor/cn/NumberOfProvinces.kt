package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntArray

//547 省份数量
/* [[1,1,0],[1,1,0],[0,0,1]] */

fun main() {
    val result = NumberOfProvinces.Solution()::findCircleNum
    assertThat(result("[[1,1,0],[1,1,0],[0,0,1]]".to2DIntArray()), equalTo(2))
    assertThat(result("[[1,0,0],[0,1,0],[0,0,1]]".to2DIntArray()), equalTo(3))
    assertThat(result("[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]".to2DIntArray()), equalTo(1))
}

class NumberOfProvinces {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findCircleNum(isConnected: Array<IntArray>): Int {
            val n = isConnected.size
            val ancestor = IntArray(n) { it }
            fun find(i: Int): Int {
                if (ancestor[i] != i)
                    ancestor[i] = find(ancestor[i])
                return ancestor[i]
            }

            fun union(i: Int, j: Int) {
                ancestor[find(i)] = find(j)
            }

            for (i in 0 until n) {
                for (j in i until n) {
                    if (isConnected[i][j] == 1)
                        union(i, j)
                }
            }
            val set = HashSet<Int>().also { ancestor.mapTo(it, ::find) }
            return set.size
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}