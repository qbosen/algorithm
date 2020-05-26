package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 寻找重复数
// 287
/* [1,3,4,2,2] */

fun main() {
    val result = FindTheDuplicateNumber.Solution()::findDuplicate
    assertThat(result("[1,3,4,2,2]".to1DIntArray()), equalTo(2))
    assertThat(result("[3,1,3,4,2]".to1DIntArray()), equalTo(3))
}

class FindTheDuplicateNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findDuplicate(nums: IntArray): Int {
            var slow = 0
            var fast = 0
            do {
                slow = nums[slow]
                fast = nums[nums[fast]]
            } while (slow != fast)
            slow = 0
            while (slow != fast) {
                slow = nums[slow]
                fast = nums[fast]
            }
            return slow
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}