package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to2DIntArray

// 最小路径和
// 64
/* [[1,3,1],[1,5,1],[4,2,1]] */

fun main() {
    val result = MinimumPathSum.Solution()::minPathSum
    assertThat(result("[[1,3,1],[1,5,1],[4,2,1]]".to2DIntArray()), equalTo(7))
}

class MinimumPathSum {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun minPathSum(grid: Array<IntArray>): Int {
            if (grid.isEmpty() || grid[0].isEmpty()) return 0
            val m = grid.size
            val n = grid[0].size
            val dp = IntArray(n)
            for (i in 0 until n) {
                dp[i] = if (i == 0) grid[0][0] else dp[i - 1] + grid[0][i]
            }
            for (i in 1 until m) {
                for (j in 0 until n) {
                    val prev = if (j == 0) dp[0] else Math.min(dp[j], dp[j - 1])
                    dp[j] = prev + grid[i][j]
                }
            }

            return dp.last()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}