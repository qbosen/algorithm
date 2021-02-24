package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import java.util.*

// 判断子序列
// 392
/* "abc","ahbgdc" */

fun main() {
    val result = IsSubsequence.Solution()::isSubsequence
    assertThat(result("", ""), equalTo(true))
    assertThat(result("abc", "ahbgdc"), equalTo(true))
    assertThat(result("axc", "ahbgdc"), equalTo(false))
    assertThat(result("aaaaaa", "bbaaaa"), equalTo(false))
}

class IsSubsequence {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isSubsequence(s: String, t: String): Boolean {
            if (t.isEmpty()) return s.isEmpty()
            // dp[i][j] 表示i及i之后，第一个元素j的位置
            val m = t.length
            val dp = Array(m + 1) { IntArray(26) }
            Arrays.fill(dp[m], m)
            dp[t.lastIndex][t.last() - 'a'] = t.lastIndex

            for (i in m - 1 downTo 0) {
                for (j in 0 until 26)
                    dp[i][j] = dp[i + 1][j]
                dp[i][t[i] - 'a'] = i
            }
            // 跳表
            var next = -1
            for (c in s) {
                next = dp[next + 1][c - 'a']
                if (next >= m) {
                    return false
                }
            }
            return true
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}