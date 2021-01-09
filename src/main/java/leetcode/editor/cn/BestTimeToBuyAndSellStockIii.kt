package leetcode.editor.cn
import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

// 123 买卖股票的最佳时机 III
/* [3,3,5,0,0,3,1,4] */

fun main() {
    val result = BestTimeToBuyAndSellStockIii.Solution()::maxProfit
    assertThat(result("[3,3,5,0,0,3,1,4]".to1DIntArray()), equalTo(6 ))
}

class BestTimeToBuyAndSellStockIii{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxProfit(prices: IntArray): Int {
        val n: Int = prices.size
        var buy1 = -prices[0]
        var sell1 = 0
        var buy2 = -prices[0]
        var sell2 = 0
        for (i in 1 until n) {
            buy1 = Math.max(buy1, -prices[i])
            sell1 = Math.max(sell1, buy1 + prices[i])
            buy2 = Math.max(buy2, sell1 - prices[i])
            sell2 = Math.max(sell2, buy2 + prices[i])
        }
        return sell2
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}