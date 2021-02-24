package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 214 最短回文串
/* "aacecaaa" */

fun main() {
    val result = ShortestPalindrome.Solution()::shortestPalindrome
    assertThat(result("aacecaaa"), equalTo("aaacecaaa"))
    assertThat(result("abcd"), equalTo("dcbabcd"))
}

class ShortestPalindrome {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun shortestPalindrome(s: String): String {
            val ss = s.toCharArray().joinToString("#", "#", "#")
            val dp = IntArray(ss.length)
            dp[0] = 0
            var cm = 0
            var bm = 0

            var palindL = 0     // 左边回文最大长度

            for (i in 1 until ss.length) {
                var radius = 1
                if (i < bm && bm > 0) {
                    val mirrorI = 2 * cm - i
                    radius = Math.min(dp[mirrorI], bm - i + 1)
                }
                while (i - radius >= 0 && i + radius < ss.length && ss[i - radius] == ss[i + radius]) {
                    radius++
                }
                // 检查左边界是不是到了起点
                if (i - radius + 1 == 0 && palindL < radius - 1) {
                    palindL = radius - 1
                }
                dp[i] = radius
                val bound = i + radius - 1
                if (bound > bm) {
                    cm = i
                    bm = bound
                }
            }

            return s.substring(palindL).reversed()+s
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}