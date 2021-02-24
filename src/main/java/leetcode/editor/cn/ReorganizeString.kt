package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*

//767 重构字符串
/* "aab" */

fun main() {
    val result = ReorganizeString.Solution()::reorganizeString
    assertThat(result("aab"), equalTo("aba"))
    assertThat(result("aaab"), equalTo(""))
}

class ReorganizeString {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun reorganizeString(S: String): String {
            val info = CharArray(S.length) { '.' }
            val counter = HashMap<Char, Int>()
            S.forEach { counter[it] = (counter[it] ?: 0) + 1 }
            var i = 0
            for (c in counter.keys.sortedByDescending { counter[it]!! }) {
                val v = counter[c]!!
                for (j in 0 until v) {
                    while (info[i] != '.') {
                        i = (i + 1) % info.size
                    }
                    info[i] = c
                    i = (i + 2) % info.size
                }
            }
            val builder = StringBuilder()
            info.forEachIndexed { idx, it ->
                if (idx + 1 < info.size && info[idx + 1] == it) {
                    return ""
                }
                builder.append(it)
            }
            return builder.toString()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}