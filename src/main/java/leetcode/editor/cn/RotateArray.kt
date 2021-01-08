package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

//189 旋转数组
/* [1,2,3,4,5,6,7],3 */

fun main() {
    val result = RotateArray.Solution()::rotate
    assertThat("[1,2,3,4,5,6,7]".to1DIntArray().also { result(it, 3) }, equalTo("[5,6,7,1,2,3,4]".to1DIntArray()))
    assertThat("[-1,-100,3,99]".to1DIntArray().also { result(it, 2) }, equalTo("[3,99,-1,-100]".to1DIntArray()))
}

class RotateArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun rotate(nums: IntArray, k: Int) {
            val k = k % nums.size
            reverse(nums, 0, nums.size - 1)
            reverse(nums, 0, k - 1)
            reverse(nums, k, nums.size - 1)
        }

        private fun reverse(nums: IntArray, start: Int, end: Int) {
            var start = start
            var end = end
            while (start < end) {
                nums[start] = nums[end].also { nums[end] = nums[start] }
                start++.also { end-- }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}