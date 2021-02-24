package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 1365 有多少小于当前数字的数字
/* [8,1,2,2,3] */

fun main() {
    val result = HowManyNumbersAreSmallerThanTheCurrentNumber.Solution()::smallerNumbersThanCurrent
    assertThat(result("[8,1,2,2,3]".to1DIntArray()), equalTo("[4,0,1,1,3]".to1DIntArray()))
    assertThat(result("[6,5,4,8]".to1DIntArray()), equalTo("[2,1,0,3]".to1DIntArray()))
    assertThat(result("[7,7,7,7]".to1DIntArray()), equalTo("[0,0,0,0]".to1DIntArray()))
}

class HowManyNumbersAreSmallerThanTheCurrentNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
            val count = IntArray(101)
            nums.forEach { count[it]++ }
            for (i in 1..100) {
                count[i] += count[i - 1]
            }
            val res = IntArray(nums.size)
            for (i in nums.indices) {
                res[i] = if (nums[i] == 0) 0 else count[nums[i] - 1]
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}