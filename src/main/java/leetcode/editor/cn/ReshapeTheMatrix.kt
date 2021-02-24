package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntArray

// 566 重塑矩阵
/* [[1,2],[3,4]],1,4 */

fun main() {
    val result = ReshapeTheMatrix.Solution()::matrixReshape
    assertThat(result("[[1,2],[3,4]]".to2DIntArray(), 1, 4), equalTo("[[1,2,3,4]]".to2DIntArray()))
}

class ReshapeTheMatrix {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun matrixReshape(nums: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
            val m = nums.size
            val n = nums[0].size
            if (m * n != r * c) return nums

            val res = Array(r) { IntArray(c) }
            for (i in 0 until m) {
                for (j in 0 until n) {
                    val idx = i * n + j
                    res[idx / c][idx % c] = nums[i][j]
                }
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}