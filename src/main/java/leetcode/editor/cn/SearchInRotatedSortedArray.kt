package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 搜索旋转排序数组
// 33
/* [4,5,6,7,0,1,2],0 */

fun main() {
    val result = SearchInRotatedSortedArray.Solution()::search
    assertThat(result("[4,5,6,7,0,1,2]".to1DIntArray(), 0), equalTo(4))
    assertThat(result("[4,5,6,7,0,1,2]".to1DIntArray(), 3), equalTo(-1))
}

class SearchInRotatedSortedArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun search(nums: IntArray, target: Int): Int {
            if (nums.isEmpty()) return -1
            if (nums.size == 1) return if (target == nums[0]) 0 else -1

            var l = 0
            var r = nums.lastIndex

            while (l <= r) {
                val mid = l + ((r - l) shr 1)
                if (nums[mid] == target) return mid

                if (nums[0] <= nums[mid]) {
                    // 左有序
                    if (nums[0] <= target && target < nums[mid]) {
                        r = mid - 1
                    } else {
                        l = mid + 1
                    }
                } else {
                    // 右有序
                    if (nums[mid] < target && target <= nums.last()) {
                        l = mid + 1
                    } else {
                        r = mid - 1
                    }
                }
            }
            return -1
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}