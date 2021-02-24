package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 打家劫舍
// 198
/* [1,2,3,1] */

fun main() {
    val result = HouseRobber.Solution()::rob
    assertThat(result("[1,2,3,1]".to1DIntArray()), equalTo(4))
    assertThat(result("[2,7,9,3,1]".to1DIntArray()), equalTo(12))
    assertThat(result("[2,7,9,3,1,20]".to1DIntArray()), equalTo(31))
}

class HouseRobber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun rob(nums: IntArray): Int {
            val dp = IntArray(2)
            for(v in nums){
                val prev = dp[0]
                dp[0] = Math.max(dp[0],dp[1])
                dp[1] = prev + v
            }

            return Math.max(dp[0],dp[1])
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}