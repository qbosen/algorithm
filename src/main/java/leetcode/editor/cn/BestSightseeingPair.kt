package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 最佳观光组合
// 1014
/* [8,1,5,2,6] */

fun main() {
    val result = BestSightseeingPair.Solution()::maxScoreSightseeingPair
    assertThat(result("[8,1,5,2,6]".to1DIntArray()), equalTo(11))
}

class BestSightseeingPair {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxScoreSightseeingPair(A: IntArray): Int {
            var mxA = A[0]
            var res = 0
            for (i in 1..A.lastIndex) {
                res = Math.max(res, mxA + A[i] - i)
                mxA = Math.max(mxA, A[i] + i)
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}