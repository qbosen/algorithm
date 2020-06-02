package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 求1+2+…+n
// 面试题64
/* 3 */

fun main() {
    val result = Qiu12nLcof.Solution()::sumNums
    assertThat(result(3), equalTo(6))
    assertThat(result(9), equalTo(45))
}

class Qiu12nLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun sumNums(n: Int): Int {
            return if (n == 0) 0 else n + sumNums(n - 1)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}