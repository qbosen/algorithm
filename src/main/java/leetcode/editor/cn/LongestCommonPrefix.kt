package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 最长公共前缀
// 14
/* ["flower","flow","flight"] */

fun main() {
    val result = LongestCommonPrefix.Solution()::longestCommonPrefix
    assertThat(result(arrayOf("flower", "flow", "flight")), equalTo("fl"))
}

class LongestCommonPrefix {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun longestCommonPrefix(strs: Array<String>): String {
            if (strs.isEmpty() || strs[0].isEmpty()) return ""

            var idx = 0

            loop@ while (true) {
                if (strs[0].length <= idx) break
                val cur = strs[0][idx]
                for (item in strs) {
                    if (item.length <= idx || item[idx] != cur) break@loop
                }
                idx++
            }
            return strs[0].substring(0 until idx)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}