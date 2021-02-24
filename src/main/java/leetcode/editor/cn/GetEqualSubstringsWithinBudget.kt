package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*

//1208 尽可能使字符串相等
/* "abcd","bcdf",3 */

fun main() {
    val result = GetEqualSubstringsWithinBudget.Solution()::equalSubstring
    assertThat(result("abcd", "bcdf", 3), equalTo(3))
    assertThat(result("abcd", "cdef", 3), equalTo(1))
    assertThat(result("abcd", "acde", 0), equalTo(1))
}

class GetEqualSubstringsWithinBudget {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun equalSubstring(s: String, t: String, maxCost: Int): Int {
            val n = s.length
            val diff = IntArray(n) { Math.abs(s[it] - t[it]) }
            val diffPrefixSum = IntArray(n + 1)
            var diffSum = 0
            for (i in 1..n) {
                diffSum += diff[i - 1]
                diffPrefixSum[i] = diffSum
            }

            var maxLength = 0
            // 左闭右开
            var left = 0
            var right = 1
            while (right in left..n) {
                if (diffPrefixSum[right] - diffPrefixSum[left] <= maxCost) {
                    val len = right - left
                    if (maxLength < len) maxLength = len
                    right++
                } else {
                    left++
                }
            }

            return maxLength
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}