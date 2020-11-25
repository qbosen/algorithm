package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*

//1370 上升下降字符串
/* "aaaabbbbcccc" */

fun main() {
    val result = IncreasingDecreasingString.Solution()::sortString
    assertThat(result("aaaabbbbcccc"), equalTo("abccbaabccba"))
    assertThat(result("rat"), equalTo("art"))
    assertThat(result("leetcode"), equalTo("cdelotee"))
    assertThat(result("leetcode"), equalTo("cdelotee"))
    assertThat(result("ggggggg"), equalTo("ggggggg"))
    assertThat(result("spo"), equalTo("ops"))
}

class IncreasingDecreasingString {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun sortString(s: String): String {
            val bucket = IntArray(26)
            s.forEach { bucket[it - 'a']++ }

            val sb = StringBuffer(s.length)
            while (sb.length < s.length) {
                for (i in 0..bucket.lastIndex) {
                    if (bucket[i] > 0) {
                        sb.append('a' + i)
                        bucket[i]--
                    }
                }
                for (i in bucket.lastIndex downTo 0) {
                    if (bucket[i] > 0) {
                        sb.append('a' + i)
                        bucket[i]--
                    }
                }
            }
            return sb.toString()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}