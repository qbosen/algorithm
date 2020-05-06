package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 最低票价
// 983
/* [1,4,6,7,8,20],[2,7,15] */

fun main() {
    val result = MinimumCostForTickets.Solution()::mincostTickets
    assertThat(result("[1,4,6,7,8,20]".to1DIntArray(), "[2,7,15]".to1DIntArray()), equalTo(11))
    assertThat(result("[1,2,3,4,5,6,7,8,9,10,30,31]".to1DIntArray(), "[2,7,15]".to1DIntArray()), equalTo(17))
    assertThat(result("[]".to1DIntArray(), "[2,7,15]".to1DIntArray()), equalTo(0))
    assertThat(result("[2]".to1DIntArray(), "[2,7,15]".to1DIntArray()), equalTo(2))
}

class MinimumCostForTickets {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun mincostTickets(days: IntArray, costs: IntArray): Int {
            // dp[n] = dp[n-1]  n不需要旅游
            // dp[n] = min{dp[n-1]+cost[0], dp[n-7]+cost[1], dp[n-30]+cost[2]}
            if(days.isEmpty()) return 0
            val dp = IntArray(366)
            fun dp(i: Int) = if (i < 0) 0 else dp[i]
            fun min(vararg ints: Int) = ints.reduce { acc, i -> Math.min(acc, i) }

            var d = 0   // days
            for (i in 1..dp.lastIndex) {
                if (days[d] == i) {
                    dp[i] = min(dp(i - 1) + costs[0], dp(i - 7) + costs[1], dp(i - 30) + costs[2])
                    if (++d == days.size) {
                        break
                    }
                } else {
                    dp[i] = dp[i - 1]
                }
            }
            return dp[days.last()]
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}