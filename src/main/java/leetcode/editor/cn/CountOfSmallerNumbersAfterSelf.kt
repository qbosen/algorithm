package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 计算右侧小于当前元素的个数
// 315
/* [5,2,6,1] */

fun main() {
    val result = CountOfSmallerNumbersAfterSelf.Solution()::countSmaller
    assertThat(result("[5,2,6,1]".to1DIntArray()), equalTo("[2,1,1,0]".to1DIntArray().asList()))
    assertThat(result("[-1,-1]".to1DIntArray()), equalTo("[0,0]".to1DIntArray().asList()))
}

class CountOfSmallerNumbersAfterSelf {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class BIT(size: Int) {
            val tree = IntArray(size + 1)

            fun update(i: Int, delta: Int) {
                var idx = i + 1
                while (idx < tree.size) {
                    tree[idx] += delta
                    idx += idx and -idx
                }
            }

            fun prefixSum(i: Int): Int {
                var idx = i + 1
                var res = 0
                while (idx > 0) {
                    res += tree[idx]
                    idx -= idx and -idx
                }
                return res
            }
        }

        fun countSmaller(nums: IntArray): List<Int> {
            val res = ArrayList<Int>(nums.size)
            if (nums.isEmpty()) return res

            val min = nums.min()!!
            val max = nums.asSequence().mapIndexed { index, i -> (i - min).also { nums[index] = it } }.max()!!
            val bit = BIT(max + 1)
            for (i in nums.lastIndex downTo 0) {
                bit.update(nums[i], 1)
                res.add(bit.prefixSum(nums[i] - 1))
            }
            return res.reversed()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}