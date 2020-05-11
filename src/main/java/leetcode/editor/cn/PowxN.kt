package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.number.IsCloseTo

// Pow(x, n)
// 50
/* 2.00000,10 */

fun main() {
    val result = PowxN.Solution()::myPow
    val error = 0.00001
    assertThat(result(2.00000, 10), IsCloseTo(1024.0, error))
    assertThat(result(2.10000, 3), IsCloseTo(9.26100, error))
    assertThat(result(2.00000, -2), IsCloseTo(0.25, error))
    assertThat(result(2.00000, Int.MIN_VALUE), IsCloseTo(0.0, error))
    assertThat(result(1.0, Int.MIN_VALUE), IsCloseTo(1.0, error))
    assertThat(result(-1.00000, Int.MIN_VALUE), IsCloseTo(1.0, error))
}

class PowxN {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun myPow(x: Double, n: Int): Double {
            // 负数比正数多一个
            var pow: Long = if (n < 0) -n.toLong() else n.toLong()
            var res = 1.0
            var cur = x
            while (pow > 0) {
                if ((pow and 1) == 1L) {
                    res *= cur
                }
                pow = pow shr 1
                cur *= cur
            }

            return if (n < 0) 1 / res else res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}