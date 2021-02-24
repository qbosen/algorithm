package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 除数博弈
// 1025
/* 2 */

fun main() {
    val result = DivisorGame.Solution()::divisorGame
    assertThat(result(2), equalTo(true))
    assertThat(result(3), equalTo(false))
    assertThat(result(4), equalTo(true))
    assertThat(result(5), equalTo(false))
}

class DivisorGame {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun divisorGame(N: Int): Boolean {
            val dp = BooleanArray(N + 2)
            dp[1] = false
            dp[2] = true
            for (i in 3..N) {
                for (x in 1 until i) {
                    if (i % x == 0 && !dp[i - x]) {
                        dp[i] = true
                        break
                    }
                }
            }

            return dp[N]
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}