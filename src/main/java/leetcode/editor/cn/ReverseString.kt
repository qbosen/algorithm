package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DCharArray

// 反转字符串
// 344
/* ["h","e","l","l","o"] */

fun main() {
    val result = ReverseString.Solution()::reverseString
    assertThat("""["h","e","l","l","o"]""".to1DCharArray().apply(result), equalTo("""["o","l","l","e","h"]""".to1DCharArray()))
    assertThat("""["H","a","n","n","a","h"]""".to1DCharArray().apply(result), equalTo("""["h","a","n","n","a","H"]""".to1DCharArray()))
}

class ReverseString {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun reverseString(s: CharArray) {
            var i = 0
            var j = s.lastIndex
            while (i < j) {
                val temp = s[i]
                s[i] = s[j]
                s[j] = temp
                i++
                j--
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}