package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntArray
import java.util.*
import kotlin.collections.ArrayList

//1030 距离顺序排列矩阵单元格
/* 1,2,0,0 */

fun main() {
    val result = MatrixCellsInDistanceOrder.Solution()::allCellsDistOrder
    assertThat(result(1, 2, 0, 0), equalTo("[[0,0],[0,1]]".to2DIntArray()))
    assertThat(result(2, 2, 0, 1), anyOf(equalTo("[[0,1],[0,0],[1,1],[1,0]]".to2DIntArray()), equalTo("[[0,1],[1,1],[0,0],[1,0]]".to2DIntArray())))
    assertThat(result(2, 3, 1, 2), anyOf(equalTo("[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]".to2DIntArray()), equalTo("[[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]".to2DIntArray())))
}

class MatrixCellsInDistanceOrder {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun allCellsDistOrder(R: Int, C: Int, r0: Int, c0: Int): Array<IntArray> {
            val res = Array(R * C) { IntArray(2) }
            val maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0)
            val buckets = Array<LinkedList<IntArray>>(maxDist + 1) { LinkedList() }

            for (i in 0 until R) {
                for (j in 0 until C) {
                    val dist = Math.abs(i - r0) + Math.abs(j - c0)
                    buckets[dist].add(intArrayOf(i, j))
                }
            }

            var idx = 0
            buckets.forEach { list -> list.forEach { res[idx++] = it } }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}