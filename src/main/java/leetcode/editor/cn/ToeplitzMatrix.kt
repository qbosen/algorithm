package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntArray

//766 托普利茨矩阵
/* [[1,2,3,4],[5,1,2,3],[9,5,1,2]] */

fun main() {
    val result = ToeplitzMatrix.Solution()::isToeplitzMatrix
    assertThat(result("[[1,2,3,4],[5,1,2,3],[9,5,1,2]]".to2DIntArray()), equalTo(true))
    assertThat(result("[[1,2],[2,2]]".to2DIntArray()), equalTo(false))
}

class ToeplitzMatrix {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
            var prev = matrix[0]
            for (i in 1 until matrix.size) {
                val current = matrix[i]
                for (j in 0 until prev.lastIndex) {
                    if (prev[j] != current[j + 1]) return false
                }
                prev = current
            }
            return true
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}