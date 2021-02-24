package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*

//738 单调递增的数字
/* 10 */

fun main() {
    val result = MonotoneIncreasingDigits.Solution()::monotoneIncreasingDigits
    assertThat(result(10), equalTo(9))
    assertThat(result(1234), equalTo(1234))
    assertThat(result(332), equalTo(299))
    assertThat(result(12221), equalTo(11999))
}

class MonotoneIncreasingDigits {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun monotoneIncreasingDigits(N: Int): Int {
            val chars = N.toString().toCharArray()
            var i = 1
            while (i < chars.size && chars[i - 1] <= chars[i]) {
                i++
            }
            if (i < chars.size) {
                while (i > 0 && chars[i - 1] > chars[i]) {
                    chars[i - 1]--
                    i--
                }
                for (it in i + 1 until chars.size) {
                    chars[it] = '9'
                }
            }
            return Integer.parseInt(String(chars))
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}