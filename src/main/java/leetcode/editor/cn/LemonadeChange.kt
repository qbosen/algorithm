package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

//860 柠檬水找零
/* [5,5,5,10,20] */

fun main() {
    val result = LemonadeChange.Solution()::lemonadeChange
    assertThat(result("[5,5,5,10,20]".to1DIntArray()), equalTo(true))
    assertThat(result("[5,5,10]".to1DIntArray()), equalTo(true))
    assertThat(result("[10,10]".to1DIntArray()), equalTo(false))
    assertThat(result("[5,5,10,10,20]".to1DIntArray()), equalTo(false))
}

class LemonadeChange {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun lemonadeChange(bills: IntArray): Boolean {
            var five = 0
            var ten = 0
            fun change(money: Int): Boolean {
                when (money) {
                    5 -> five++
                    10 -> ten++.also { five-- }
                    20 -> if (ten > 0) ten--.also { five-- } else five -= 3
                }
                return five >= 0 && ten >= 0
            }

            for (bill in bills) {
                if (!change(bill)) return false
            }
            return true
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}