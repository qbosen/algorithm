package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 486 预测赢家
/* [1,5,2] */

fun main() {
    val result = PredictTheWinner.Solution()::PredictTheWinner
    assertThat(result("[1,5,2]".to1DIntArray()), equalTo(false))
    assertThat(result("[1,5,233,7]".to1DIntArray()), equalTo(true))
}

class PredictTheWinner {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun PredictTheWinner(nums: IntArray): Boolean {
            //dp[i][j] 表示(i,j)的闭区间时，先手比对手高的分数
            // i=j 先手高这么多分 i>j 0
            // dp[i][j] = max{nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]}
            val dp = Array(nums.size) { IntArray(nums.size) }
            for (i in nums.indices) {
                dp[i][i] = nums[i]
            }
            for (i in nums.lastIndex - 1 downTo 0) {
                for (j in i + 1..nums.lastIndex) {
                    dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1])
                }
            }
            return dp[0][nums.lastIndex] >= 0
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}