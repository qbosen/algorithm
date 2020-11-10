package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

//31 下一个排列
/* [1,2,3] */

fun main() {
    val result = NextPermutation.Solution()::nextPermutation
    assertThat("[1,2,3]".to1DIntArray().apply(result), equalTo("[1,3,2]".to1DIntArray()))
    assertThat("[3,2,1]".to1DIntArray().apply(result), equalTo("[1,2,3]".to1DIntArray()))
    assertThat("[1,1,5]".to1DIntArray().apply(result), equalTo("[1,5,1]".to1DIntArray()))
    assertThat("[1,3,2]".to1DIntArray().apply(result), equalTo("[2,1,3]".to1DIntArray()))
}

class NextPermutation {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun nextPermutation(nums: IntArray): Unit {
            if (nums.isEmpty() || nums.size == 1) return
            fun reverse(i: Int, j: Int) {
                var a = i
                var b = j
                while (a < b) {
                    nums[a] = nums[b].also { nums[b] = nums[a] }
                    a++.also { b-- }
                }
            }

            for (i in nums.lastIndex - 1 downTo 0) {
                if (nums[i + 1] > nums[i]) {
                    for (j in nums.lastIndex downTo i + 1) {
                        if (nums[j] > nums[i]) {
                            nums[i] = nums[j].also { nums[j] = nums[i] }
                            reverse(i + 1, nums.lastIndex)
                            return
                        }
                    }
                }
            }
            reverse(0, nums.lastIndex)

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}