package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

//714 买卖股票的最佳时机含手续费
/* [1,3,2,8,4,9],2 */

fun main() {
    val result = BestTimeToBuyAndSellStockWithTransactionFee.Solution()::maxProfit
    assertThat(result("[1,3,2,8,4,9]".to1DIntArray(), 2), equalTo(8))
}

class BestTimeToBuyAndSellStockWithTransactionFee {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxProfit(prices: IntArray, fee: Int): Int {
            // dp 利润
            // dp[i][hold:true] = math.max(dp[i-1][true], dp[i-1][false] - prices[i])
            // dp[i][hold:false] = math.max(dp[i-1][true] + prices[i] -fee, dp[i-1][false])
            val dp = Array(prices.size) { IntArray(2) }
            dp[0][0] = -prices[0]
            dp[0][1] = 0

            for (i in 1..prices.lastIndex) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i])
                dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1])
            }
            return dp[dp.lastIndex][1]
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}