package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray
import java.util.*

//1438 绝对差不超过限制的最长连续子数组
/* [8,2,4,7],4 */

fun main() {
    val result = LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit.Solution()::longestSubarray
    assertThat(result("[8,2,4,7]".to1DIntArray(), 4), equalTo(2))
    assertThat(result("[10,1,2,4,7,2]".to1DIntArray(), 5), equalTo(4))
    assertThat(result("[4,2,2,2,4,4,2,2]".to1DIntArray(), 0), equalTo(3))
}

class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun longestSubarray(nums: IntArray, limit: Int): Int {
            val maxQue = LinkedList<Int>()
            val minQue = LinkedList<Int>()
            var left = 0
            var right = 0
            var res = 0
            while (right < nums.size) {
                val current = nums[right]
                while (maxQue.isNotEmpty() && maxQue.peekLast() < current) maxQue.pollLast()
                while (minQue.isNotEmpty() && minQue.peekLast() > current) minQue.pollLast()

                maxQue.offerLast(current)
                minQue.offerLast(current)

                while (maxQue.isNotEmpty() && minQue.isNotEmpty() && maxQue.peek() - minQue.peek() > limit) {
                    when (nums[left]) {
                        minQue.peek() -> minQue.pollFirst()
                        maxQue.peek() -> maxQue.pollFirst()
                    }
                    left++
                }
                res = Math.max(res, right - left + 1)
                right++
            }

            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}