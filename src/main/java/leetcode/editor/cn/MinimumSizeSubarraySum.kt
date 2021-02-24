package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray
import java.util.*

// 长度最小的子数组
// 209
/* 7,[2,3,1,2,4,3] */

fun main() {
    val result = MinimumSizeSubarraySum.Solution()::minSubArrayLen
    assertThat(result(7, "[2,3,1,2,4,3]".to1DIntArray()), equalTo(2))
    assertThat(result(1, "[2,3,1,2,4,3]".to1DIntArray()), equalTo(1))
    assertThat(result(1, "[2,3,3,2,4,3]".to1DIntArray()), equalTo(1))
    assertThat(result(100, "[2,3,3,2,4,3]".to1DIntArray()), equalTo(0))
    assertThat(result(15, "[1,2,3,4,5]".to1DIntArray()), equalTo(5))
}

class MinimumSizeSubarraySum {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun minSubArrayLen(s: Int, nums: IntArray): Int {
            if (nums.isEmpty()) return 0
            val prefixSum = IntArray(nums.size + 1)
            for (i in nums.indices) {
                prefixSum[i + 1] = prefixSum[i] + nums[i]
            }
            var result = Int.MAX_VALUE
            for (i in 0..prefixSum.lastIndex) {
                val target = s + prefixSum[i]
                var bound = Arrays.binarySearch(prefixSum, target)
                if (bound < 0) {
                    bound = -bound - 1
                }
                if (bound <= prefixSum.lastIndex) {
                    result = Math.min(result, bound - i)
                }
            }
            return if (result == Int.MAX_VALUE) 0 else result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}