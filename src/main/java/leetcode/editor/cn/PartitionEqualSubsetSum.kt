package leetcode.editor.cn
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 分割等和子集
// 416
/* [1,5,11,5] */

fun main() {
    val result = PartitionEqualSubsetSum.Solution()::canPartition
    assertThat(result("[1,5,11,5]".to1DIntArray()), equalTo(true))
    assertThat(result("[1,2,3,5]".to1DIntArray()), equalTo(false))
}

class PartitionEqualSubsetSum{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val n: Int = nums.size
        if (n < 2) {
            return false
        }
        var sum = 0
        var maxNum = 0
        for (num in nums) {
            sum += num
            maxNum = Math.max(maxNum, num)
        }
        if (sum % 2 != 0) {
            return false
        }
        val target = sum / 2
        if (maxNum > target) {
            return false
        }
        val dp = BooleanArray(target + 1)
        dp[0] = true
        for (i in 0 until n) {
            val num = nums[i]
            for (j in target downTo num) {
                dp[j] = dp[j] or dp[j - num]
            }
        }
        return dp[target]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}