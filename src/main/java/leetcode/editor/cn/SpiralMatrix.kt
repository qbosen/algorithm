package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray
import util.to2DIntArray

// 螺旋矩阵
// 54
/* [[1,2,3],[4,5,6],[7,8,9]] */

fun main() {
    val result = SpiralMatrix.Solution()::spiralOrder
    assertThat(result("[[1,2,3],[4,5,6],[7,8,9]]".to2DIntArray()), equalTo("[1,2,3,6,9,8,7,4,5]".to1DIntArray().toList()))
    assertThat(result("[[1,2,3,4],[5,6,7,8],[9,10,11,12]]".to2DIntArray()), equalTo("[1,2,3,4,8,12,11,10,9,5,6,7]".to1DIntArray().toList()))

}

class SpiralMatrix {
    //leetcode submit region begin(Prohibit modification and deletion)
//@Suppress("DuplicatedCode")
    class Solution {
        fun spiralOrder(matrix: Array<IntArray>): List<Int> {
            if (matrix.isEmpty() || matrix[0].isEmpty()) return emptyList()
            val rows = matrix.size
            val cols = matrix[0].size
            val res = ArrayList<Int>(rows * cols)
            var l = 0
            var r = cols - 1
            var top = 0
            var btm = rows - 1

            while (l <= r && top <= btm) {
                for (j in l..r) res.add(matrix[top][j])
                for (i in top + 1..btm) res.add(matrix[i][r])
                if (l < r && top < btm) {   // 偶数行
                    for (j in r - 1 downTo l + 1) res.add(matrix[btm][j])
                    for (i in btm downTo top + 1) res.add(matrix[i][l])
                }
                l++
                r--
                top++
                btm--
            }

            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}