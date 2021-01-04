package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*

//509 斐波那契数
/* 2 */

fun main() {
    val result = FibonacciNumber.Solution()::fib
    assertThat(result(2), equalTo(1))
    assertThat(result(3), equalTo(2))
    assertThat(result(4), equalTo(3))
}

class FibonacciNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun fib(n: Int): Int {
            if (n == 0) return 0
            else if (n == 1) return 1
            var p = 0
            var c = 1
            for (i in 2..n) {
                val next = p + c
                p = c
                c = next
            }
            return c
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}