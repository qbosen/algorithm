package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*

// 无重复字符的最长子串
// 3
/* "abcabcbb" */

fun main() {
    val result = LongestSubstringWithoutRepeatingCharacters.Solution()::lengthOfLongestSubstring
    assertThat(result("abcabcbb"), equalTo(3))
    assertThat(result("bbbbb"), equalTo(1))
    assertThat(result("pwwkew"), equalTo(3))
    assertThat(result(""), equalTo(0))
    assertThat(result("acbdcfe"), equalTo(5))
    assertThat(result("abba"), equalTo(2))
    assertThat(result("tmmzuxt"), equalTo(5))
}

class LongestSubstringWithoutRepeatingCharacters {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        inline fun max(a: Int, b: Int): Int = if (a < b) b else a

        fun lengthOfLongestSubstring(s: String): Int {
            var res = 0
            val map = HashMap<Char, Int>()
            var l = -1
            for(i in s.indices){
                if (s[i] in map && map[s[i]]!! > l) {
                    l = map[s[i]]!!
                }

                map[s[i]] = i
                res = max(res, i - l)
            }

            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}