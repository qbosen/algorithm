package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

// 992 K 个不同整数的子数组
/* [1,2,1,2,3],2 */

fun main() {
    val result = SubarraysWithKDifferentIntegers.Solution()::subarraysWithKDistinct
    assertThat(result("[1,2,1,2,3]".to1DIntArray(), 2), equalTo(7))
    assertThat(result("[1,2,1,3,4]".to1DIntArray(), 3), equalTo(3))
}

class SubarraysWithKDifferentIntegers {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun subarraysWithKDistinct(A: IntArray, K: Int): Int {
            return atMostKDistinct(A, K) - atMostKDistinct(A, K - 1)
        }

        fun atMostKDistinct(A: IntArray, K: Int): Int {
            val freq = IntArray(A.size + 1)
            var count = 0
            var l = 0
            var r = 0
            var res = 0

            while (r < A.size) {
                if (freq[A[r]] == 0) count++
                freq[A[r]]++
                r++
                while (count > K) {
                    freq[A[l]]--
                    if (freq[A[l]] == 0) count--
                    l++
                }
                res += r - l
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}