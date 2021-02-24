package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.either
import org.hamcrest.Matchers.equalTo

// 最长回文子串
// 5
/* "babad" */

fun main() {
    val result = LongestPalindromicSubstring.Solution()::longestPalindrome
    assertThat(result("babad"), either(equalTo("bab")).or(equalTo("aba")))
    assertThat(result("cbbs"), equalTo("bb"))

}

class LongestPalindromicSubstring {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun longestPalindrome(s: String): String {
            if (s.isEmpty()) return ""
            fun expand(l: Int, r: Int): Int {
                var ll = l
                var rr = r

                while (ll >= 0 && rr < s.length && s[ll] == s[rr]) {
                    ll--
                    rr++
                }
                return rr - ll - 1
            }

            var start = 0
            var end = 0
            for (i in s.indices) {
                val len = Math.max(expand(i, i), expand(i, i + 1))
                if (len > end - start) {
                    start = i - (len - 1) / 2
                    end = i + len / 2
                }
            }

            return s.substring(start..end)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}