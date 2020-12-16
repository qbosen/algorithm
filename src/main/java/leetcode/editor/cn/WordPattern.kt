package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*

//290 单词规律
/* "abba","dog,cat,cat,dog" */

fun main() {
    val result = WordPattern.Solution()::wordPattern
    assertThat(result("abba", "dog cat cat dog"), equalTo(true))
    assertThat(result("abba", "dog cat cat fish"), equalTo(false))
    assertThat(result("aaaa", "dog cat cat dog"), equalTo(false))
    assertThat(result("abba", "dog dog dog dog"), equalTo(false))
}

class WordPattern {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun wordPattern(pattern: String, s: String): Boolean {
            if (pattern.isBlank() && s.isBlank()) return true
            val split = s.split(" ")
            if (split.size != pattern.length) return false
            val mapping = HashMap<Char, String>()
            for (i in pattern.indices) {
                val old = mapping[pattern[i]]
                if (old == null) {
                    mapping[pattern[i]] = split[i]
                } else {
                    if (old != split[i]) return false
                }
            }

            return mapping.values.toSet().size == mapping.size
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}