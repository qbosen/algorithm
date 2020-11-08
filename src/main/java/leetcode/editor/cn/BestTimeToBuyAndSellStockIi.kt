package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

// 122 买卖股票的最佳时机 II
/* [7,1,5,3,6,4] */

fun main() {
    val result = BestTimeToBuyAndSellStockIi.Solution()::maxProfit
    assertThat(result("[7,1,5,3,6,4]".to1DIntArray()), equalTo(7))
}

class BestTimeToBuyAndSellStockIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxProfit(prices: IntArray): Int {
            var ans = 0
            for (i in 1 until prices.size) {
                ans += Math.max(0, prices[i] - prices[i - 1])
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}