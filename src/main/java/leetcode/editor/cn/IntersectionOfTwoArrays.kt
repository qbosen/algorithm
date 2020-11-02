package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 349 两个数组的交集
/* [1,2,2,1],[2,2] */

fun main() {
    val result = IntersectionOfTwoArrays.Solution()::intersection
    assertThat(result("[1,2,2,1]".to1DIntArray(), "[2,2]".to1DIntArray()), equalTo(intArrayOf(2)))
    assertThat(result("[4,9,5]".to1DIntArray(), "[9,4,9,8,4]".to1DIntArray()), equalTo("[4,9]".to1DIntArray()))
}

class IntersectionOfTwoArrays {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
            val set2 = nums2.toSet()
            return nums1.asSequence().filter { set2.contains(it) }.distinct().toList().toIntArray()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}