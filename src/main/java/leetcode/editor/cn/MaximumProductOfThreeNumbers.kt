package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

//628 三个数的最大乘积
/* [1,2,3] */

fun main() {
    val result = MaximumProductOfThreeNumbers.Solution()::maximumProduct
    assertThat(result("[1,2,3]".to1DIntArray()), equalTo(6))
    assertThat(result("[1,2,3,4]".to1DIntArray()), equalTo(24))
    assertThat(result("[1,2,3,4,-3,-3]".to1DIntArray()), equalTo(36))
    assertThat(result("[-1,-2,-3,-4]".to1DIntArray()), equalTo(-6))
}

class MaximumProductOfThreeNumbers {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maximumProduct(nums: IntArray): Int {
            val min = IntArray(2) { Int.MAX_VALUE }
            val max = IntArray(3) { Int.MIN_VALUE }
            for (num in nums) {
                when {
                    num < min[0] -> {
                        min[1] = min[0]
                        min[0] = num
                    }
                    num < min[1] -> min[1] = num
                }
                when {
                    num > max[2] -> {
                        max[0] = max[1]
                        max[1] = max[2]
                        max[2] = num
                    }
                    num > max[1] -> {
                        max[0] = max[1]
                        max[1] = num
                    }
                    num > max[0] -> max[0] = num
                }
            }
            return Math.max(min[0] * min[1] * max[2], max[0] * max[1] * max[2])
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}