package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 和可被 K 整除的子数组
// 974
/* [4,5,0,-2,-3,1],5 */

fun main() {
    val result = SubarraySumsDivisibleByK.Solution()::subarraysDivByK
    assertThat(result("[4,5,0,-2,-3,1]".to1DIntArray(), 5), equalTo(7))
    assertThat(result("[0,5,10]".to1DIntArray(), 5), equalTo(6))
}

class SubarraySumsDivisibleByK {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun subarraysDivByK(A: IntArray, K: Int): Int {
            val modMap = IntArray(K)
            modMap[0] = 1
            var s = 0
            var res = 0
            for (i in A) {
                s += i
                val idx = (s % K).let { if (it < 0) it + K else it }
                res += modMap[idx]
                modMap[idx]++
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}