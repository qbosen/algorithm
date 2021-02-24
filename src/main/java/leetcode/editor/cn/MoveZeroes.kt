package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

//283 移动零
/* [0,1,0,3,12] */

fun main() {
    val result = MoveZeroes.Solution()::moveZeroes
    assertThat("[0,1,0,3,12]".to1DIntArray().apply(result), equalTo("[1,3,12,0,0]".to1DIntArray()))
}

class MoveZeroes {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun moveZeroes(nums: IntArray): Unit {
            var zCount = 0
            for (i in nums.indices) {
                if (nums[i] == 0) zCount++ else {
                    nums[i - zCount] = nums[i]
                }
            }
            for (i in nums.size - zCount until nums.size) {
                nums[i] = 0
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}