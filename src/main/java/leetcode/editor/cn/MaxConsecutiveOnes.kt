package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

// 485 最大连续 1 的个数
/* [1,0,1,1,0,1] */

fun main() {
    val result = MaxConsecutiveOnes.Solution()::findMaxConsecutiveOnes
    assertThat(result("[1,1,0,1,1,1]".to1DIntArray()), equalTo(3))
}

class MaxConsecutiveOnes {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findMaxConsecutiveOnes(nums: IntArray): Int {
            var res = 0
            var count = 0
            for (i in nums) {
                if (i == 1) count++
                else {
                    res = Math.max(res, count)
                    count = 0
                }
            }
            res = Math.max(res, count)
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}