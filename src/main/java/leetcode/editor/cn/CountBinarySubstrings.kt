package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 计数二进制子串
// 696
/* "00110" */

fun main() {
    val result = CountBinarySubstrings.Solution()::countBinarySubstrings
    assertThat(result("00110011"), equalTo(6))
    assertThat(result("00110"), equalTo(3))
    assertThat(result("10101"), equalTo(4))
    assertThat(result(""), equalTo(0))
}

class CountBinarySubstrings {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun countBinarySubstrings(s: String): Int {
            tailrec fun countFrom(start: Int, toAdd: Int): Int {
                var idx = start
                while (idx < s.length && s[idx] == s[start]) {
                    idx++
                }
                val pivot = idx
                if (pivot == s.length || pivot == start) return toAdd
                while (idx < s.length && s[idx] == s[pivot]) {
                    idx++
                }
                return countFrom(pivot, toAdd + Math.min(pivot - start, idx - pivot))
            }
            return countFrom(0,0)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}