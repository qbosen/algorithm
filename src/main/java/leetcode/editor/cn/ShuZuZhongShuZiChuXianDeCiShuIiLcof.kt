package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 数组中数字出现的次数 II
// 面试题56 - II
/* [3,4,3,3] */

fun main() {
    val result = ShuZuZhongShuZiChuXianDeCiShuIiLcof.Solution()::singleNumber
    assertThat(result("[3,4,3,3]".to1DIntArray()), equalTo(4))
    assertThat(result("[9,1,7,9,7,9,7]".to1DIntArray()), equalTo(1))
}

class ShuZuZhongShuZiChuXianDeCiShuIiLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun singleNumber(nums: IntArray): Int {
            var one = 0
            var two = 0

            for (num in nums) {
                one = two.inv() and (num xor one)
                two = one.inv() and (num xor two)
            }
            return one
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}