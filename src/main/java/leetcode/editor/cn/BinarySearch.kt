package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 二分查找
// 704
/* [-1,0,3,5,9,12],9 */

fun main() {
    val result = BinarySearch.Solution()::search
    assertThat(result("[-1,0,3,5,9,12]".to1DIntArray(), 9), equalTo(4))
    assertThat(result("[-1,0,3,5,9,12]".to1DIntArray(), 2), equalTo(-1))
}

class BinarySearch {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun search(nums: IntArray, target: Int): Int {
            var l = 0
            var r = nums.lastIndex

            while (l <= r) {
                val mid = l + ((r - l) shr 1)
                when {
                    nums[mid] < target -> l = mid + 1
                    nums[mid] > target -> r = mid - 1
                    nums[mid] == target -> return mid
                }
            }

            return -1
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}