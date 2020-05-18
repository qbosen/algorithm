package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 乘积最大子数组
// 152
/* [2,3,-2,4] */

fun main() {
    val result = MaximumProductSubarray.Solution()::maxProduct
    assertThat(result("[2,3,-2,4]".to1DIntArray()), equalTo(6))
    assertThat(result("[-2,0,-1]".to1DIntArray()), equalTo(0))
    assertThat(result("[3]".to1DIntArray()), equalTo(3))
    assertThat(result("[1,2,3,-4,1,-1,2,0,10]".to1DIntArray()), equalTo(48))
    assertThat(result("[1,2,3,-4,1,-1,2,0,50]".to1DIntArray()), equalTo(50))
}

class MaximumProductSubarray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxProduct(nums: IntArray): Int {
            val minDp = IntArray(nums.size)
            val maxDp = IntArray(nums.size)
            fun minMax(vararg args: Int): Pair<Int, Int> = args.fold(args[0] to args[0]) { acc, i ->
                Math.min(acc.first, i) to Math.max(acc.second, i)
            }

            fun dp(i: Int): Pair<Int, Int> = if (i == 0) nums[i] to nums[i] else
                minMax(minDp[i - 1] * nums[i], maxDp[i - 1] * nums[i], nums[i])

            var res = nums[0]
            for (i in nums.indices) {
                dp(i).run { minDp[i] = first;maxDp[i] = second }
                res = Math.max(res, maxDp[i])
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}