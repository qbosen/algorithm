package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*

// 硬币
// 面试题 08.11
// 5

fun main() {
    val result = Solution()::waysToChange
    assertThat(result(5), equalTo(2))
    assertThat(result(10), equalTo(4))
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun waysToChange(n: Int): Int {
        //f(i,n)=f(i,n-ci)+f(i-1,n)
        val mod = 1000000007
        val coins = intArrayOf(1, 5, 10, 25)
        val dp = IntArray(n + 1)
        dp[0] = 1

        for (coin in coins) {
            for (i in coin..n){
                dp[i] = (dp[i] + dp[i-coin]) % mod
            }
        }
        return dp[n]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

