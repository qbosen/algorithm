package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to2DCharArray

// 最大正方形
// 221
/* [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]] */

fun main() {
    val result = MaximalSquare.Solution()::maximalSquare
    assertThat(result("""[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]""".to2DCharArray()), equalTo(4))
    assertThat(result("""[["1"]]""".to2DCharArray()), equalTo(1))
    assertThat(result("""[["1","1"]]""".to2DCharArray()), equalTo(1))
    assertThat(result("""[["1","1","1"],["1","1","1"],["1","1","1"]]""".to2DCharArray()), equalTo(9))
}

class MaximalSquare {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maximalSquare(matrix: Array<CharArray>): Int {
            fun dp(i: Int, j: Int): Char {
                return when {
                    i < 0 || i >= matrix.size -> 0.toChar()
                    j < 0 || j >= matrix[0].size -> 0.toChar()
                    else -> matrix[i][j]
                }
            }

            fun min(vararg nums: Char): Char = nums.reduce { acc, c -> if (acc > c) c else acc }

            if (matrix.isEmpty()) return 0
            var res = 0
            for (i in matrix.indices) {
                for (j in matrix[0].indices) {
                    matrix[i][j] = if (matrix[i][j] == '0') 0.toChar() else
                        min(dp(i - 1, j), dp(i, j - 1), dp(i - 1, j - 1)) + 1
                    res = if (matrix[i][j].toInt() > res) matrix[i][j].toInt() else res
                }
            }

            return res * res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}