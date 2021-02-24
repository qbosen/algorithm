package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 34 在排序数组中查找元素的第一个和最后一个位置
/* [5,7,7,8,8,10],8 */

fun main() {
    val result = FindFirstAndLastPositionOfElementInSortedArray.Solution()::searchRange
    assertThat(result("[5,7,7,8,8,10]".to1DIntArray(), 8), equalTo("[3,4]".to1DIntArray()))
    assertThat(result("[5,7,7,8,8,10]".to1DIntArray(), 6), equalTo("[-1,-1]".to1DIntArray()))
    assertThat(result("[]".to1DIntArray(), 0), equalTo("[-1,-1]".to1DIntArray()))
}

class FindFirstAndLastPositionOfElementInSortedArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun searchRange(nums: IntArray, target: Int): IntArray {
            if (nums.isEmpty()) return intArrayOf(-1, -1)
            var low = 0
            var high = nums.lastIndex
            while (low <= high) {
                val mid = (high + low) / 2
                when {
                    nums[mid] == target -> {
                        var i = mid - 1
                        var j = mid + 1
                        while (i >= 0 && nums[i] == target) i--
                        while (j <= nums.lastIndex && nums[j] == target) j++
                        return intArrayOf(i + 1, j - 1)
                    }
                    nums[mid] < target -> low = mid + 1
                    nums[mid] > target -> high = mid - 1
                }
            }
            return intArrayOf(-1, -1)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}