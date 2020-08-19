package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 回文子串
// 647
/* "abc" */

fun main() {
    val result = PalindromicSubstrings.Solution()::countSubstrings
    assertThat(result("a"), equalTo(1))
    assertThat(result("abc"), equalTo(3))
    assertThat(result("aaa"), equalTo(6))
    assertThat(result("dnncbwoneinoplypwgbwktmvkoimcooyiwirgbxlcttgteqthcvyoueyftiwgwwxvxvg"), equalTo(77))
}

class PalindromicSubstrings {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun countSubstrings(s: String): Int {
            if (s.isEmpty()) return 0
            val ss = s.toCharArray().joinToString("#", "#", "#")
            val dp = IntArray(ss.length)  // 中心位i的最大回文半径
            dp[0] = 0
            var cm = 0  // 最大右端点中心位
            var bm = 0  // 最大右端点边界位

            var result = 0
            for (i in 1 until ss.length) {
                var radius = 1
                if (i < bm && bm > 0) { // dp优化
                    val mirrorI = 2 * cm - i
                    radius = Math.min(dp[mirrorI], bm - i + 1) // 至少的回文半径
                }
                while (i - radius >= 0 && i + radius < ss.length && ss[i - radius] == ss[i + radius]) {
                    radius++
                }
                dp[i] = radius
                result += radius / 2      // 有效个数是最大回文半径的一半

                val newBound = i + radius - 1   // 注意radius=1的边界
                if (newBound > bm) {
                    cm = i
                    bm = newBound
                }
            }
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}