package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// x 的平方根
// 69
/* 4 */

fun main() {
    val result = Sqrtx.Solution()::mySqrt
    assertThat(result(4), equalTo(2))
    assertThat(result(9), equalTo(3))
    assertThat(result(8), equalTo(2))
    assertThat(result(0), equalTo(0))
    assertThat(result(2147395599), equalTo(46339))
}

class Sqrtx {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun mySqrt(x: Int): Int {
            var l = 0
            var r = x
            var res = -1
            while (l <= r) {
                val mid = l + ((r - l) shr 1)
                val square = mid.toLong() * mid
                if (square <= x) {
                    res = mid
                    l = mid + 1
                } else {
                    r = mid - 1
                }
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}