package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray
import java.util.*


//455 分发饼干
/* [1,2,3],[1,1] */

fun main() {
    val result = AssignCookies.Solution()::findContentChildren
    assertThat(result("[1,2,3]".to1DIntArray(), "[1,1]".to1DIntArray()), equalTo(1))
    assertThat(result("[1,2]".to1DIntArray(), "[1,2,3]".to1DIntArray()), equalTo(2))
}

class AssignCookies {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findContentChildren(g: IntArray, s: IntArray): Int {

            Arrays.sort(g)
            Arrays.sort(s)
            var count = 0

            var i = 0
            var j = 0
            while (i < g.size && j < s.size) {
                while (j < s.size && g[i] > s[j]) {
                    j++
                }
                if (j < s.size) {
                    count++
                }
                i++
                j++
            }

            return count

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}