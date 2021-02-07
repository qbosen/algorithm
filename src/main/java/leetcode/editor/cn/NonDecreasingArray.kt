package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

//665 非递减数列
/* [4,2,3] */

fun main() {
    val result = NonDecreasingArray.Solution()::checkPossibility
    assertThat(result("[4,2,3]".to1DIntArray()), equalTo(true))
    assertThat(result("[4,2,1]".to1DIntArray()), equalTo(false))
    assertThat(result("[3,4,2,3]".to1DIntArray()), equalTo(false))
    assertThat(result("[5,7,1,8]".to1DIntArray()), equalTo(true))
}

class NonDecreasingArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun checkPossibility(nums: IntArray): Boolean {
            if (nums.size <= 1) return true
            var cnt = 0
            for (i in 0 until nums.size - 1) {

                if (nums[i] > nums[i + 1]) {
                    cnt++
                    if (cnt > 1) return false
                    if (i > 0 && nums[i + 1] < nums[i - 1]) {
                        nums[i + 1] = nums[i]
                    }
                }
            }
            return true
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}