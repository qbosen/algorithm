package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 验证回文字符串 Ⅱ
// 680
/* "aba" */

fun main() {
    val result = ValidPalindromeIi.Solution()::validPalindrome
    assertThat(result("aba"), equalTo(true))
    assertThat(result("abca"), equalTo(true))
    assertThat(result("adbcdba"), equalTo(false))
    assertThat(result("adbbdba"), equalTo(true))
    assertThat(result("adbddba"), equalTo(true))
}

class ValidPalindromeIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private fun validPalindrome(s: String, l: Int, r: Int): Boolean {
            var l = l
            var r = r
            while (l < r) {
                if (s[l] != s[r]) {
                    return false
                }
                l++
                r--
            }
            return true
        }

        fun validPalindrome(s: String): Boolean {
            var l = 0
            var r = s.lastIndex
            while (l < r) {
                if (s[l] != s[r]) {
                    return validPalindrome(s, l, r - 1) || validPalindrome(s, l + 1, r)
                }
                l++
                r--
            }
            return true
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}