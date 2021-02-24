package leetcode.editor.cn
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 颜色分类
// 75
/* [2,0,2,1,1,0] */

fun main() {
    val result = SortColors.Solution()::sortColors
    assertThat("[2,0,2,1,1,0]".to1DIntArray().apply(result), equalTo("[0,0,1,1,2,2]".to1DIntArray()))
}

class SortColors{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun sortColors(nums: IntArray) {
        val n: Int = nums.size
        var ptr = 0
        for (i in 0 until n) {
            if (nums[i] == 0) {
                val temp = nums[i]
                nums[i] = nums[ptr]
                nums[ptr] = temp
                ++ptr
            }
        }
        for (i in ptr until n) {
            if (nums[i] == 1) {
                val temp = nums[i]
                nums[i] = nums[ptr]
                nums[ptr] = temp
                ++ptr
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}