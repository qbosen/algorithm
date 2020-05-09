package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 猜数字大小
// 374
/* 10,6 */

fun main() {
    fun guess(bound: Int, target: Int) {
        val solution = GuessNumberHigherOrLower.Solution().apply { setPick(target) }
        assertThat(solution.guessNumber(bound), equalTo(target))
    }

    guess(10, 6)
    guess(10, 2)
    guess(1000, 500)
}

class GuessNumberHigherOrLower {
    abstract class GuessGame {

        abstract fun guessNumber(n: Int): Int
        var target: Int = -1
        fun setPick(pick: Int) {
            target = pick
        }

        fun guess(num: Int): Int = when {
            target < num -> -1
            target > num -> 1
            else -> 0
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution : GuessGame() {
        override fun guessNumber(n: Int): Int {
            var l = 1
            var r = n
            while (l <= r) {
                val mid = l + ((r - l) shr 1)
                when (guess(mid)) {
                    0 -> return mid
                    1 -> l = mid + 1
                    -1 -> r = mid - 1
                }
            }
            return l
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}