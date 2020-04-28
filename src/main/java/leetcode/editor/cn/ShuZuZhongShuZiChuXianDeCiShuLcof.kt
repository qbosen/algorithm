package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.collection.ArrayMatching.arrayContainingInAnyOrder
import util.to1DIntArray

// 数组中数字出现的次数
// 面试题56 - I
/* [4,1,4,6] */

fun main() {
    val result = ShuZuZhongShuZiChuXianDeCiShuLcof.Solution()::singleNumbers
    val test = { input: String, expect: String ->
        val ints = input.to1DIntArray()
        val expects = expect.to1DIntArray().toTypedArray()
        assertThat(result(ints).toTypedArray(), arrayContainingInAnyOrder(*expects))
    }
    test("[4,1,4,6]", "[1,6]")
    test("[1,2,5,2]", "[1,5]")
}

class ShuZuZhongShuZiChuXianDeCiShuLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun singleNumbers(nums: IntArray): IntArray {
            val bothXor = nums.reduce { acc, i -> acc xor i }
            val dif = bothXor and -bothXor
            var a = 0
            var b = 0

            nums.forEach {
                when (it and dif) {
                    0 -> a = a xor it
                    dif -> b = b xor it
                }
            }
            return intArrayOf(a, b)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}