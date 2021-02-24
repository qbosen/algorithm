package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 魔术索引
// 面试题 08.03
/* [0,,2,,3,,4,,5] */

fun main() {
    val result = MagicIndexLcci.Solution()::findMagicIndex
    assertThat(result("[0,2,3,4,5]".to1DIntArray()), equalTo(0))
    assertThat(result("[0,0,2,2,5]".to1DIntArray()), equalTo(0))
    assertThat(result("[1,1,1]".to1DIntArray()), equalTo(1))
    assertThat(result("[-1,0,1,2,4]".to1DIntArray()), equalTo(4))
}

class MagicIndexLcci {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findMagicIndex(nums: IntArray): Int {
            fun getAnswer(l: Int, r: Int): Int {
                if (l > r) return -1
                val mid = (r - l) / 2 + l
                val leftResult = getAnswer(l, mid - 1)
                return when {
                    leftResult != -1 -> leftResult
                    nums[mid] == mid -> mid
                    else -> getAnswer(mid + 1, r)
                }
            }

            return getAnswer(0, nums.lastIndex)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}