package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 只出现一次的数字
// 136
/* [2,2,1] */

fun main() {
    val result = SingleNumber.Solution()::singleNumber
    assertThat(result("[2,2,1]".to1DIntArray()), equalTo(1))
    assertThat(result("[4,1,2,1,2]".to1DIntArray()), equalTo(4))
    assertThat(result("[4]".to1DIntArray()), equalTo(4))
}

class SingleNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun singleNumber(nums: IntArray): Int {
            return nums.reduce { acc, i -> acc xor i }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}