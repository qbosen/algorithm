package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 快乐数
// 202
/* 19 */

fun main() {
    val result = HappyNumber.Solution()::isHappy
    assertThat(result(19), equalTo(true))
    assertThat(result(82), equalTo(true))
}

class HappyNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private val square: Map<Int, Int> = (0..9).associateWith { it * it }

        fun isHappy(n: Int): Boolean {
            val set = HashSet<Int>()
            var cur = n
            while (cur !in set) {
                if (cur == 1) return true
                set.add(cur)
                cur = cal(cur)
            }

            return false
        }

        private fun cal(n: Int): Int {
            var n = n
            var res = 0
            while (n != 0) {
                res += square[n % 10]!!
                n /= 10
            }
            return res
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}