package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

//674 最长连续递增序列
/* [1,3,5,4,7] */

fun main() {
    val result = LongestContinuousIncreasingSubsequence.Solution()::findLengthOfLCIS
    assertThat(result("[1,3,5,4,7]".to1DIntArray()), equalTo(3))
    assertThat(result("[2,2,2,2,2]".to1DIntArray()), equalTo(1))
}

class LongestContinuousIncreasingSubsequence {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findLengthOfLCIS(nums: IntArray): Int {
            if (nums.isEmpty()) return 0
            var res = 1
            var prev = nums[0]
            var length = 1
            for (i in 1 until nums.size) {
                if (nums[i] > prev) {
                    length++
                    if (length > res) {
                        res = length
                    }
                } else {
                    length = 1
                }
                prev = nums[i]
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}