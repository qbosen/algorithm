package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 验证回文串
// 125
/* "A,man,,a,plan,,a,canal:,Panama" */

fun main() {
    val result = ValidPalindrome.Solution()::isPalindrome
    assertThat(result("A man, a plan, a canal: Panama"), equalTo(true))
    assertThat(result("race a car"), equalTo(false))
    assertThat(result(",."), equalTo(true))
    assertThat(result(""), equalTo(true))
}

class ValidPalindrome {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isPalindrome(s: String): Boolean {
            var l = 0
            var r = s.lastIndex
            while (l < r) {
                while (l < r && !s[l].isLetterOrDigit()) {
                    l++
                }
                while (l < r && !s[r].isLetterOrDigit()) {
                    r--
                }
                if (l >= r) return true
                if (s[l] != s[r] && s[l].toLowerCase() != s[r].toLowerCase()) return false
                l++
                r--
            }
            return true
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}