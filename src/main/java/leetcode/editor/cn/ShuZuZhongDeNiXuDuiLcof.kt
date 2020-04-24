package leetcode.editor.cn;

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 数组中的逆序对
// 面试题51
/* [7,5,6,4] */

fun main() {
    val result = ShuZuZhongDeNiXuDuiLcof.Solution()::reversePairs
    assertThat(result("[7,5,6,4]".to1DIntArray()), equalTo(5))
}

class ShuZuZhongDeNiXuDuiLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun reversePairs(nums: IntArray): Int {
            if (nums.size < 2) return 0

            val temp = nums.copyOf()
            return reversePairsInner(nums, 0, nums.lastIndex, temp)
        }


        private fun reversePairsInner(nums: IntArray, left: Int, right: Int, temp: IntArray): Int {
            if (left == right) return 0

            val mid = left + ((right - left) shr 1)
            val leftPairCount = reversePairsInner(nums, left, mid, temp)
            val rightPairCount = reversePairsInner(nums, mid + 1, right, temp)
            if (nums[mid] <= nums[mid + 1]) // 双边有序
                return leftPairCount + rightPairCount
            val crossPairCount = mergeAndCount(nums, left, mid, right, temp)

            return leftPairCount + rightPairCount + crossPairCount
        }

        private fun mergeAndCount(nums: IntArray, left: Int, mid: Int, right: Int, temp: IntArray): Int {
            for (i in left..right) {
                temp[i] = nums[i]
            }

            var i = left
            var j = mid + 1
            var reverseCount = 0
            for (c in left..right) {
                when {
                    i == mid + 1 -> nums[c] = temp[j++]
                    j == right + 1 -> nums[c] = temp[i++]
                    temp[i] <= temp[j] -> nums[c] = temp[i++]
                    else -> {
                        nums[c] = temp[j++]
                        reverseCount += mid - i + 1
                    }
                }
            }
            return reverseCount
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}