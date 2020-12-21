package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

//746 使用最小花费爬楼梯
/* [0,0,0,0] */

fun main() {
    val result = MinCostClimbingStairs.Solution()::minCostClimbingStairs
    assertThat(result("[0,0,0,0]".to1DIntArray()), equalTo(0))
    assertThat(result("[10,15,20]".to1DIntArray()), equalTo(15))
    assertThat(result("[1,100,1,1,1,100,1,1,100,1]".to1DIntArray()), equalTo(6))
}

class MinCostClimbingStairs {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun minCostClimbingStairs(cost: IntArray): Int {
            val dp = IntArray(cost.size)
            dp[0] = cost[0]
            dp[1] = cost[1]
            for (i in 2 until dp.size) {
                dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i]
            }
            return Math.min(dp[cost.lastIndex], dp[cost.lastIndex - 1])
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}