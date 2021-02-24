package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*

//424 替换后的最长重复字符
/* "ABAB",2 */

fun main() {
    val result = LongestRepeatingCharacterReplacement.Solution()::characterReplacement
    assertThat(result("ABAB", 2), equalTo(4))
    assertThat(result("AABABBA", 1), equalTo(4))
}

class LongestRepeatingCharacterReplacement {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun characterReplacement(s: String, k: Int): Int {
            val count = IntArray(26)
            var maxC = 0
            var left = 0
            var right = 0

            while (right < s.length) {
                count[s[right] - 'A']++
                maxC = Math.max(maxC, count[s[right] - 'A'])
                if (right - left + 1 - maxC > k) {
                    count[s[left] - 'A']--
                    left++
                }
                right++
            }
            return right - left
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}