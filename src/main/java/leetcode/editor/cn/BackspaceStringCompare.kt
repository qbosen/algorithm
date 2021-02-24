package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 844 比较含退格的字符串
/* "ab#c","ad#c" */

fun main() {
    val result = BackspaceStringCompare.Solution()::backspaceCompare
    assertThat(result("ab#c", "ad#c"), equalTo(true))
    assertThat(result("ab##", "c#d#"), equalTo(true))
    assertThat(result("a##c", "#a#c"), equalTo(true))
    assertThat(result("a#c", "b"), equalTo(false))
    assertThat(result("bxj##tw", "bxo#j##tw"), equalTo(true))
    assertThat(result("bbbextm", "bbb#extm"), equalTo(false))
}

class BackspaceStringCompare {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun backspaceCompare(S: String, T: String): Boolean {
            var p1 = S.lastIndex
            var p2 = T.lastIndex

            while (p1 >= 0 || p2 >= 0) {
                var del = 0
                while (p1 >= 0) {
                    if (S[p1] == '#') del++.also { p1-- }
                    else if (del > 0) del--.also { p1-- }
                    else break
                }

                del = 0
                while (p2 >= 0) {
                    if (T[p2] == '#') del++.also { p2-- }
                    else if (del > 0) del--.also { p2-- }
                    else break
                }
                if (p1 >= 0 && p2 >= 0 && S[p1] != T[p2]) return false
                if ((p1 < 0 && p2 >= 0) || (p2 < 0 && p1 >= 0)) return false
                p1--
                p2--
            }
            return true
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}