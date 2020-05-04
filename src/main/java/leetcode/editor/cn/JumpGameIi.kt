package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

// 跳跃游戏 II
// 45
/* [2,3,1,1,4] */

fun main() {
    val result = JumpGameIi.Solution()::jump
    assertThat(result("[2,3,1,1,4]".to1DIntArray()), equalTo(2))
}

class JumpGameIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun jump(nums: IntArray): Int {
            var end = 0     // 当前能走的最远点
            var maxP = 0    // 下一轮能走的最远点
            var steps = 0
            var i = 0       // 遍历点

            while (end < nums.size - 1) {
                maxP = Math.max(maxP, i + nums[i])
                if (i == end) {
                    end = maxP
                    steps++
                }
                i++
            }
            return steps
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}