package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 只出现一次的数字 II
// 137
/* [2,2,3,2] */

fun main() {
    val result = SingleNumberIi.Solution()::singleNumber
    assertThat(result("[2,2,3,2]".to1DIntArray()), equalTo(3))
}

class SingleNumberIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun singleNumber(nums: IntArray): Int {
            var one = 0
            var two = 0
            for (num in nums) {
                one = two.inv() and num xor one
                two = one.inv() and num xor two
            }
            return one
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}