package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 整数拆分
// 343
/* 2 */

fun main() {
    val result = IntegerBreak.Solution()::integerBreak
    assertThat(result(2), equalTo(1))
    assertThat(result(3), equalTo(2))
    assertThat(result(4), equalTo(4))
    assertThat(result(5), equalTo(6))
    assertThat(result(6), equalTo(9))
    assertThat(result(7), equalTo(12))
    assertThat(result(10), equalTo(36))
}

class IntegerBreak {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun integerBreak(n: Int): Int {
            if (n <= 3) return n - 1
            val c = n / 3
            return when (n % 3) {
                0 -> Math.pow(3.0, c.toDouble()).toInt()
                1 -> Math.pow(3.0, c - 1.0).toInt() * 4
                2 -> Math.pow(3.0, c.toDouble()).toInt() * 2
                else -> 0
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}