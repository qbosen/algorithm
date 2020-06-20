package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo


// 正则表达式匹配
// 10
/* "aa","a" */

fun main() {
    val result = RegularExpressionMatching.Solution()::isMatch
    assertThat(result("aa", "a"), equalTo(false))
    assertThat(result("aa", "a*"), equalTo(true))
    assertThat(result("ab", ".*"), equalTo(true))
    assertThat(result("aab", "c*a*b"), equalTo(true))
    assertThat(result("mississippi", "mis*is*p*."), equalTo(false))
}

class RegularExpressionMatching {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isMatch(s: String, p: String): Boolean {
            val m: Int = s.length
            val n: Int = p.length
            fun matches(i: Int, j: Int): Boolean {
                return when {
                    i == 0 -> false
                    p[j - 1] == '.' -> true
                    else -> s[i - 1] == p[j - 1]
                }
            }

            val f = Array(m + 1) { BooleanArray(n + 1) }
            f[0][0] = true
            for (i in 0..m) {
                for (j in 1..n) {
                    if (p[j - 1] == '*') {
                        f[i][j] = f[i][j - 2]
                        if (matches(i, j - 1)) {
                            f[i][j] = f[i][j] || f[i - 1][j]
                        }
                    } else {
                        if (matches(i, j)) {
                            f[i][j] = f[i - 1][j - 1]
                        }
                    }
                }
            }
            return f[m][n]
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}