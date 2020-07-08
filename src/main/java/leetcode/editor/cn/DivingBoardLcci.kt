package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 跳水板
// 面试题 16.11
/* 1,1,0 */

fun main() {
    val result = DivingBoardLcci.Solution()::divingBoard
    assertThat(result(1, 1, 0), equalTo(intArrayOf()))
    assertThat(result(1, 2, 3), equalTo(intArrayOf(3, 4, 5, 6)))
}

class DivingBoardLcci {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun divingBoard(shorter: Int, longer: Int, k: Int): IntArray {
            if (k == 0) return intArrayOf()
            val kl = k * longer
            if (shorter == longer) return intArrayOf(kl)
            val d = longer - shorter
            val result = IntArray(k + 1)
            for (i in 0..k) {
                result[k - i] = (kl - d * i)
            }
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}