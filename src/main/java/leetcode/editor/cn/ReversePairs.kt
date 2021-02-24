package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray


// 翻转对
// 493
/* [1,3,2,3,1] */

fun main() {
    val result = ReversePairs.Solution()::reversePairs
    assertThat(result("[1,3,2,3,1]".to1DIntArray()), equalTo(2))
    assertThat(result("[2,4,3,5,1]".to1DIntArray()), equalTo(3))
    assertThat(result("[-5,-5]".to1DIntArray()), equalTo(1))
}

class ReversePairs {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun reversePairs(nums: IntArray): Int {
            if (nums.size <= 1) return 0
            val numsCopy = nums.clone().also { it.sort() }
            val BITS = IntArray(nums.size + 1)
            var count = 0
            for (i in nums.lastIndex downTo 0) {
                count += query(BITS, index(numsCopy, nums[i] / 2.0))
                update(BITS, index(numsCopy, nums[i].toDouble()))
            }
            return count
        }

        private fun update(BIT: IntArray, index: Int) {
            var index = index + 1
            while (index < BIT.size) {
                BIT[index]++
                index += index and -index
            }
        }

        private fun query(BIT: IntArray, index: Int): Int {
            var index = index
            var sum = 0
            while (index > 0) {
                sum += BIT[index]
                index -= index and -index
            }
            return sum
        }

        private fun index(arr: IntArray, `val`: Double): Int {
            var lo = 0
            var hi = arr.size
            while (lo < hi) {
                val mid = lo + (hi - lo) / 2
                if (arr[mid] >= `val`) hi = mid else lo = mid + 1
            }
            return lo
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}