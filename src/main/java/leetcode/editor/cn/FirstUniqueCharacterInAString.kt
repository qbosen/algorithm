package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*

//387 字符串中的第一个唯一字符
/* "leetcode" */

fun main() {
    val result = FirstUniqueCharacterInAString.Solution()::firstUniqChar
    assertThat(result("leetcode"), equalTo(0))
    assertThat(result("loveleetcode"), equalTo(2))
    assertThat(result("aabbccddd"), equalTo(-1))
}

class FirstUniqueCharacterInAString {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun firstUniqChar(s: String): Int {
            val map = HashMap<Char, Int>().apply {
                s.forEach {
                    compute(it) { _, v ->
                        (v ?: 0) + 1
                    }
                }
            }

            for (i in s.indices) {
                if (map[s[i]] == 1) return i
            }
            return -1
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}