package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntArray

//1128 等价多米诺骨牌对的数量
/* [[1,2],[2,1],[3,4],[5,6]] */

fun main() {
    val result = NumberOfEquivalentDominoPairs.Solution()::numEquivDominoPairs
    assertThat(result("[[1,2],[2,1],[3,4],[5,6]]".to2DIntArray()), equalTo(1))
    assertThat(result("[[1,2],[3,4],[3,4],[4,3],[5,6]]".to2DIntArray()), equalTo(3))
}

class NumberOfEquivalentDominoPairs {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
            val num = IntArray(100)
            var res = 0
            for ((a, b) in dominoes) {
                val v = if (a < b) a * 10 + b else b * 10 + a
                res += num[v]
                num[v]++
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}