package leetcode.editor.cn
import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
// 重复的子字符串
// 459
/* "abab" */

fun main() {
    val result = RepeatedSubstringPattern.Solution()::repeatedSubstringPattern
    assertThat(result("abab"), equalTo( true))
}

class RepeatedSubstringPattern{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun repeatedSubstringPattern(s: String): Boolean {
        return (s+s).indexOf(s,1) != s.length
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}