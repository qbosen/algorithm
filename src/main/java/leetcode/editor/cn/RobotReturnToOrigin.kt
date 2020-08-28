package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 657 机器人能否返回原点
/* "UD" */

fun main() {
    val result = RobotReturnToOrigin.Solution()::judgeCircle
    assertThat(result("UD"), equalTo(true))
    assertThat(result("LL"), equalTo(false))
}

class RobotReturnToOrigin {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun judgeCircle(moves: String): Boolean {
            var x = 0
            var y = 0
            for (m in moves) {
                when (m) {
                    'U' -> y++
                    'D' -> y--
                    'L' -> x--
                    'R' -> x++
                }
            }
            return x == 0 && y == 0
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}