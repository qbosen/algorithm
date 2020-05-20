package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 每个元音包含偶数次的最长子字符串
// 1371
/* "eleetminicoworoep" */

fun main() {
    val result = FindTheLongestSubstringContainingVowelsInEvenCounts.Solution()::findTheLongestSubstring
    assertThat(result("eleetminicoworoep"), equalTo(13))
    assertThat(result("leetcodeisgreat"), equalTo(5))
    assertThat(result("bcbcbc"), equalTo(6))
    assertThat(result("e"), equalTo(0))
}

class FindTheLongestSubstringContainingVowelsInEvenCounts {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findTheLongestSubstring(s: String): Int {
            val pos = IntArray(1 shl 5) { -1 }    // status:index
            pos[0] = 0
            var status = 0
            var result = 0
            for (i in s.indices) {
                status = when (s[i]) {
                    'a' -> status xor 1
                    'e' -> status xor 2
                    'i' -> status xor 4
                    'o' -> status xor 8
                    'u' -> status xor 16
                    else -> status
                }
                if (pos[status] >= 0) {
                    result = Math.max(result, i + 1 - pos[status])
                } else {
                    pos[status] = i + 1
                }
            }
            return result
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}