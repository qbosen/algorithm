package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray
import java.util.*

// 每日温度
// 739
/* [73,74,75,71,69,72,76,73] */

fun main() {
    val result = DailyTemperatures.Solution()::dailyTemperatures
    assertThat(result("[73,74,75,71,69,72,76,73]".to1DIntArray()), equalTo("[1,1,4,2,1,1,0,0]".to1DIntArray()))
}

class DailyTemperatures {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun dailyTemperatures(T: IntArray): IntArray {
            val res = IntArray(T.size)
            val stack: Deque<Int> = LinkedList()

            for (i in T.indices) {
                val temp = T[i]
                while (!stack.isEmpty() && temp > T[stack.peek()]) {
                    val prevI = stack.pop()
                    res[prevI] = i - prevI
                }
                stack.push(i)
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}