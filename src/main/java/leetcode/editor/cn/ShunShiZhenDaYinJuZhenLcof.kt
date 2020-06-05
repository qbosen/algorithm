package leetcode.editor.cn

import org.junit.Assert.assertArrayEquals
import util.to1DIntArray
import util.to2DIntArray

// 顺时针打印矩阵
// 面试题29
/* [[1,2,3],[4,5,6],[7,8,9]] */

fun main() {
    val result = ShunShiZhenDaYinJuZhenLcof.Solution()::spiralOrder
    assertArrayEquals(result("[[1,2,3],[4,5,6],[7,8,9]]".to2DIntArray()), "[1,2,3,6,9,8,7,4,5]".to1DIntArray())
    assertArrayEquals(result("[[1,2,3,4],[5,6,7,8],[9,10,11,12]]".to2DIntArray()), "[1,2,3,4,8,12,11,10,9,5,6,7]".to1DIntArray())
}

class ShunShiZhenDaYinJuZhenLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun spiralOrder(matrix: Array<IntArray>): IntArray {
            if (matrix.isEmpty() || matrix[0].isEmpty()) return IntArray(0)
            val rows = matrix.size
            val cols = matrix[0].size
            val res = IntArray(rows * cols)
            var idx = 0
            var l = 0
            var r = cols - 1
            var top = 0
            var btm = rows - 1

            while (l <= r && top <= btm) {
                for (j in l..r) res[idx++] = matrix[top][j]
                for (i in top + 1..btm) res[idx++] = matrix[i][r]
                if (l < r && top < btm) {   // 偶数行
                    for (j in r - 1 downTo l + 1) res[idx++] = matrix[btm][j]
                    for (i in btm downTo top + 1) res[idx++] = matrix[i][l]
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