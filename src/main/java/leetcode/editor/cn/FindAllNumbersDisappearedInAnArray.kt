package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

// 448 找到所有数组中消失的数字
/* [4,3,2,7,8,2,3,1] */

fun main() {
    val result = FindAllNumbersDisappearedInAnArray.Solution()::findDisappearedNumbers
    assertThat(result("[4,3,2,7,8,2,3,1]".to1DIntArray()), equalTo("[5,6]".to1DIntArray().toList()))
}

class FindAllNumbersDisappearedInAnArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findDisappearedNumbers(nums: IntArray): List<Int> {
            for (i in nums) {
                val idx = if (i > 0) i - 1 else -i - 1
                if (nums[idx] > 0) nums[idx] = -nums[idx]
            }
            val res = ArrayList<Int>()
            for (i in nums.indices) {
                if (nums[i] > 0) {
                    res.add(i + 1)
                }
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}