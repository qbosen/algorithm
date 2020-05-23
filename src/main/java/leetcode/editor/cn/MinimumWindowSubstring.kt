package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*

// 最小覆盖子串
// 76
/* "ADOBECODEBANC","ABC" */

fun main() {
    val result = MinimumWindowSubstring.Solution()::minWindow
    assertThat(result("ADOBECODEBANC", "ABC"), equalTo("BANC"))
}

class MinimumWindowSubstring {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun minWindow(s: String, t: String): String {
            if (s.isEmpty() || t.isEmpty() || s.length < t.length) return ""

            val winFreq = IntArray(128)
            val tFreq = IntArray(128)
            t.forEach { tFreq[it.toInt()]++ }
            var distance = 0
            var minL = s.length + 1
            var begin = 0

            var l = 0
            var r = 0
            //[l,r)
            while (r < s.length) {
                val rIdx = s[r].toInt()
                if (winFreq[rIdx] < tFreq[rIdx]) {   // 少就加
                    distance++
                }

                winFreq[rIdx]++.also { r++ }

                while (distance == t.length) {    // 包含所有
                    if (r - l < minL) {         // 更新结果
                        minL = r - l
                        begin = l
                    }
                    val lIdx = s[l].toInt()

                    if (winFreq[lIdx] == tFreq[lIdx]) { // 出去一个
                        distance--
                    }
                    winFreq[lIdx]--.also { l++ }
                }
            }

            return if (minL == s.length + 1) "" else s.substring(begin until begin + minL)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}