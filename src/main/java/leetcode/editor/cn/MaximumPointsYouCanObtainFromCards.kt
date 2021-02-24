package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

// 可获得的最大点数
// 1423
/* [1,2,3,4,5,6,1],3 */

fun main() {
    val result = MaximumPointsYouCanObtainFromCards.Solution()::maxScore
    assertThat(result("[1,2,3,4,5,6,1]".to1DIntArray(), 3), equalTo(8))
}

class MaximumPointsYouCanObtainFromCards {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxScore(cardPoints: IntArray, k: Int): Int {
            var sum = 0
            for (i in 0 until k) {
                sum += cardPoints[i]
            }
            var res = sum
            for (i in 0 until k) {
                val r = cardPoints.size - i - 1
                val l = k - i - 1
                sum = sum - cardPoints[l] + cardPoints[r]
                if(sum > res) res = sum
            }
            return res

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}