package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

//724 寻找数组的中心索引
/* [1,7,3,6,5,6] */

fun main() {
    val result = FindPivotIndex.Solution()::pivotIndex
    assertThat(result("[1,7,3,6,5,6]".to1DIntArray()), equalTo(3))
    assertThat(result("[1,2,3]".to1DIntArray()), equalTo(-1))
}

class FindPivotIndex {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun pivotIndex(nums: IntArray): Int {
            val sum = nums.sum()
            var lsum = 0
            // sum最大10_000_000 不会溢出
            for (i in nums.indices) {
                if (lsum * 2 + nums[i] == sum)
                    return i
                lsum += nums[i]
            }
            return -1
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}