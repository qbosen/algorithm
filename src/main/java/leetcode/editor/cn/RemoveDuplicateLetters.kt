package leetcode.editor.cn
import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*



//316 去除重复字母
/* "bcabc" */

fun main() {
    val result = RemoveDuplicateLetters.Solution()::removeDuplicateLetters
    assertThat(result("bcabc"), equalTo( "abc"))
    assertThat(result("cbacdcbc"), equalTo( "acdb"))
}

class RemoveDuplicateLetters{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun removeDuplicateLetters(s: String): String {

        val vis = BooleanArray(26)
        val num = IntArray(26)
        for (element in s) {
            num[element - 'a']++
        }

        val sb = StringBuffer()
        for (element in s) {
            val ch: Char = element
            if (!vis[ch - 'a']) {
                while (sb.isNotEmpty() && sb[sb.length - 1] > ch) {
                    if (num[sb[sb.length - 1] - 'a'] > 0) {
                        vis[sb[sb.length - 1] - 'a'] = false
                        sb.deleteCharAt(sb.length - 1)
                    } else {
                        break
                    }
                }
                vis[ch - 'a'] = true
                sb.append(ch)
            }
            num[ch - 'a'] -= 1
        }
        return sb.toString()

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}