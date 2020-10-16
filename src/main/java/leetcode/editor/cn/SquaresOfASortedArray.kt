package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 977 有序数组的平方
/* [-4,-1,0,3,10] */

fun main() {
    val result = SquaresOfASortedArray.Solution()::sortedSquares
    assertThat(result("[-4,-1,0,3,10]".to1DIntArray()), equalTo("[0,1,9,16,100]".to1DIntArray()))
    assertThat(result("[-7,-3,2,3,11]".to1DIntArray()), equalTo("[4,9,9,49,121]".to1DIntArray()))
    assertThat(result("[-1,2,2]".to1DIntArray()), equalTo("[1,4,4]".to1DIntArray()))
    assertThat(result("[-1]".to1DIntArray()), equalTo("[1]".to1DIntArray()))
}

class SquaresOfASortedArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun sortedSquares(A: IntArray): IntArray {
            var a = 0
            var b = A.lastIndex
            val result = IntArray(A.size)
            var idx = A.lastIndex
            while (idx >= 0) {
                result[idx] = if (Math.abs(A[a]) > A[b]) {
                    (A[a] * A[a]).also { a++ }
                } else {
                    (A[b] * A[b]).also { b-- }
                }
                idx--
            }
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}