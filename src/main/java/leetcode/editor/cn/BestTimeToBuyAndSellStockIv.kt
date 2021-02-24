package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray
import java.util.Arrays


//188 买卖股票的最佳时机 IV
/* 2,[2,4,1] */

fun main() {
    val result = BestTimeToBuyAndSellStockIv.Solution()::maxProfit
    assertThat(result(2, "[2,4,1]".to1DIntArray()), equalTo(2))
    assertThat(result(2, "[3,2,6,5,0,3]".to1DIntArray()), equalTo(7))
}

class BestTimeToBuyAndSellStockIv {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxProfit(k: Int, prices: IntArray): Int {
            if (prices.isEmpty()) {
                return 0
            }

            val n: Int = prices.size
            var k = Math.min(k, n / 2)
            val buy = IntArray(k + 1)
            val sell = IntArray(k + 1)

            buy[0] = -prices[0]
            sell[0] = 0
            for (i in 1..k) {
                sell[i] = Int.MIN_VALUE / 2
                buy[i] = sell[i]
            }

            for (i in 1 until n) {
                buy[0] = Math.max(buy[0], sell[0] - prices[i])
                for (j in 1..k) {
                    buy[j] = Math.max(buy[j], sell[j] - prices[i])
                    sell[j] = Math.max(sell[j], buy[j - 1] + prices[i])
                }
            }

            return Arrays.stream(sell).max().asInt
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}