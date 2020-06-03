package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.closeTo

// 新21点
// 837
/* 10,1,10 */

fun main() {
    val result = New21Game.Solution()::new21Game
    val error = 1E-5
    assertThat(result(10, 1, 10), closeTo(1.0, error))
    assertThat(result(6, 1, 10), closeTo(0.6, error))
    assertThat(result(21, 17, 10), closeTo(0.73278, error))
    assertThat(result(0,0,1), closeTo(1.0, error))
}

class New21Game {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun new21Game(N: Int, K: Int, W: Int): Double {
            /*
            d[i] = d[i+1] + (d[i+1]-d[i+1+W]) / W ; 0<=i<K-1
            d[i] = 1 ; K<=i<=min{N,K+W-1}
            d[i] = 0 ; min{N,K+W-1}<i
            d[K-1] = min{N-K+1,W} / W
            */
            if (K == 0) return 1.0
            val dp = DoubleArray(K + W + 1)
            for (i in K..Math.min(N, K + W - 1)) {
                dp[i] = 1.0
            }
            dp[K - 1] = Math.min(N - K + 1, W).toDouble() / W
            for (i in K - 2 downTo 0) {
                dp[i] = dp[i + 1] + (dp[i + 1] - dp[i + W + 1]) / W
            }
            return dp[0]
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}