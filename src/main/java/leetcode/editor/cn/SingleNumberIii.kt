package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.collection.ArrayMatching
import util.to1DIntArray

// 只出现一次的数字 III
// 260
/* [1,2,1,3,2,5] */

fun main() {
    val result = SingleNumberIii.Solution()::singleNumber
    assertThat(result("[1,2,1,3,2,5]".to1DIntArray()).toTypedArray(), ArrayMatching.arrayContainingInAnyOrder(3, 5))
    assertThat(result("[1,2,5,2]".to1DIntArray()).toTypedArray(), ArrayMatching.arrayContainingInAnyOrder(1, 5))
}

class SingleNumberIii {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun singleNumber(nums: IntArray): IntArray {
            val bxor = nums.reduce { acc, i -> acc xor i }
            val lowbit = bxor and -bxor
            val res = IntArray(2)
            nums.forEach {
                if ((it and lowbit) == 0) {
                    res[0] = res[0] xor it
                } else {
                    res[1] = res[1] xor it
                }
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}