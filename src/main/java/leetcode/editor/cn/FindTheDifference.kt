package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*

//389 找不同
/* "abcd","abcde" */

fun main() {
    val result = FindTheDifference.Solution()::findTheDifference
    assertThat(result("abcd", "abcde"), equalTo('e'))
    assertThat(result("", "y"), equalTo('y'))
    assertThat(result("a", "aa"), equalTo('a'))
    assertThat(result("ae", "aea"), equalTo('a'))
    assertThat(result("leetcode", "codeteell"), equalTo('l'))
}

class FindTheDifference {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findTheDifference(s: String, t: String): Char {
            val map = HashMap<Char, Int>()
            s.forEach { map.compute(it) { _, v -> (v ?: 0) + 1 } }
            for (c in t) {
                if (map[c] == null) return c
                map.compute(c) { _, v -> if (v == null || v == 1) null else v - 1 }
            }
            return map.iterator().next().key
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}