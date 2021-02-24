package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 和为K的子数组
// 560
/* [1,1,1],2 */

fun main() {
    val result = SubarraySumEqualsK.Solution()::subarraySum
    assertThat(result("[1,1,1]".to1DIntArray(), 2), equalTo(2))
    assertThat(result("[1,2,1]".to1DIntArray(), 2), equalTo(1))
    assertThat(result("[1,2,1]".to1DIntArray(), 3), equalTo(2))
    assertThat(result("[1,1,1,1,3]".to1DIntArray(), 4), equalTo(2))
    assertThat(result("[1,1,1,1,3,4]".to1DIntArray(), 4), equalTo(3))
    assertThat(result("[1]".to1DIntArray(), 0), equalTo(0))
}

class SubarraySumEqualsK {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun subarraySum(nums: IntArray, k: Int): Int {
            val map = HashMap<Int, Int>(nums.size + 1)  // sum:count
            var res = 0
            var pre = 0
            map[0] = 1
            for (i in nums.indices) {
                pre += nums[i]
                res += map.getOrDefault(pre - k, 0)
                map.compute(pre) { _, v -> if (v == null) 1 else v + 1 }
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}