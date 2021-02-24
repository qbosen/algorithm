package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 爬楼梯
// 70
/* 2 */

fun main() {
    val result = ClimbingStairs.Solution()::climbStairs
    assertThat(result(1), equalTo(1))
    assertThat(result(2), equalTo(2))
    assertThat(result(3), equalTo(3))
    assertThat(result(4), equalTo(5))
    assertThat(result(5), equalTo(8))
}

class ClimbingStairs {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun climbStairs(n: Int): Int {
            var p = 0
            var q = 1
            var r = 1
            for (i in 1 until n) {
                p = q
                q = r
                r = p + q
            }
            return r
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}