package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*

//62 不同路径
/* 3,7 */

fun main() {
    val result = UniquePaths.Solution()::uniquePaths
    assertThat(result(3, 7), equalTo(28))
    assertThat(result(3, 2), equalTo(3))
    assertThat(result(7, 3), equalTo(28))
    assertThat(result(3, 3), equalTo(6))
    assertThat(result(10, 10), equalTo(48620))
}

class UniquePaths {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun uniquePaths(m: Int, n: Int): Int {
            var a = m - 1
            var b = n - 1
            if (a < b) a = b.also { b = a }

            var res = 1L
            for (i in a + 1..a + b) {
                res *= i
            }
            for (i in 2.. b) {
                res /= i
            }
            return res.toInt()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}