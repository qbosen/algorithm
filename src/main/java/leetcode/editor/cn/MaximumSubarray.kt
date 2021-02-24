package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

// 最大子序和
// 53
/* [-2,1,-3,4,-1,2,1,-5,4] */

fun main() {
    val result = MaximumSubarray.Solution()::maxSubArray
    assertThat(result("[-2,1,-3,4,-1,2,1,-5,4]".to1DIntArray()), equalTo(6))
}

class MaximumSubarray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxSubArray(nums: IntArray): Int {
            var max = nums[0]
            for (i in 1..nums.lastIndex) {
                if (nums[i - 1] > 0) nums[i] += nums[i - 1]
                max = Math.max(max, nums[i])
            }
            return max
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}