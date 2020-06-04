package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 除自身以外数组的乘积
// 238
/* [1,2,3,4] */

fun main() {
    val result = ProductOfArrayExceptSelf.Solution()::productExceptSelf
    assertThat(result("[1,2,3,4]".to1DIntArray()), equalTo("[24,12,8,6]".to1DIntArray()))
}

class ProductOfArrayExceptSelf {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun productExceptSelf(nums: IntArray): IntArray {
            val result = IntArray(nums.size)
            var left = 1
            for (i in nums.indices) {
                result[i] = left
                left *= nums[i]
            }
            var right = 1
            for (i in nums.size - 1 downTo 0) {
                result[i] *= right
                right *= nums[i]
            }
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}