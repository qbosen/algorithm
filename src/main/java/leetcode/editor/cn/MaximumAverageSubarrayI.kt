package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

//643 子数组最大平均数 I
/* [1,12,-5,-6,50,3],4 */

fun main() {
    val result = MaximumAverageSubarrayI.Solution()::findMaxAverage
    assertThat(result("[1,12,-5,-6,50,3]".to1DIntArray(), 4), equalTo(12.75))
}

class MaximumAverageSubarrayI {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findMaxAverage(nums: IntArray, k: Int): Double {
            var sum = 0
            for (i in 0 until k) {
                sum += nums[i]
            }
            var maxSum = sum
            for (i in k until nums.size) {
                sum = sum + nums[i] - nums[i - k]
                if (sum > maxSum) maxSum = sum
            }
            return maxSum.toDouble() / k
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}