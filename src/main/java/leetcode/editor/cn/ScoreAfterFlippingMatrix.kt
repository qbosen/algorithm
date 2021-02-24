package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntArray

//861 翻转矩阵后的得分
/* [[0,0,1,1],[1,0,1,0],[1,1,0,0]] */

fun main() {
    val result = ScoreAfterFlippingMatrix.Solution()::matrixScore
    assertThat(result("[[0,0,1,1],[1,0,1,0],[1,1,0,0]]".to2DIntArray()), equalTo(39))
}

class ScoreAfterFlippingMatrix {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun matrixScore(A: Array<IntArray>): Int {
            val R = A.size
            val C = A[0].size
            val rowReverse = BooleanArray(R) { A[it][0] == 0 }
            var res = R * 1 shl (C - 1)
            for (c in 1 until C) {
                var ones = 0
                for (r in 0 until R) {
                    if ((rowReverse[r] && A[r][c] == 0) || (!rowReverse[r] && A[r][c] == 1)) {
                        ones++
                    }
                }
                ones = Math.max(ones, R - ones)
                res += ones * 1 shl (C - 1 - c)
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}