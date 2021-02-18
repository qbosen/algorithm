package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

// 995 K 连续位的最小翻转次数
/* [0,1,0],1 */

fun main() {
    val result = MinimumNumberOfKConsecutiveBitFlips.Solution()::minKBitFlips
    assertThat(result("[0,1,0]".to1DIntArray(), 1), equalTo(2))
    assertThat(result("[1,1,0]".to1DIntArray(), 2), equalTo(-1))
}

class MinimumNumberOfKConsecutiveBitFlips {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun minKBitFlips(A: IntArray, K: Int): Int {
            val n = A.size
            val diff = IntArray(n + 1)
            var res = 0
            var cnt = 0
            for (i in 0 until n) {
                cnt = cnt xor diff[i]
                if (A[i] == cnt) {
                    if (i + K > n) return -1
                    res++
                    cnt = cnt xor 1
                    diff[i + K] = diff[i + K] xor 1
                }
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}