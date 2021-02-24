package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 等式方程的可满足性
// 990
/* ["a==b","b!=a"] */

fun main() {
    val result = SatisfiabilityOfEqualityEquations.Solution()::equationsPossible
    assertThat(result(arrayOf("a==b", "b!=a")), equalTo(false))
    assertThat(result(arrayOf("a==b", "b==a")), equalTo(true))
    assertThat(result(arrayOf("a==b", "b==c", "c==a")), equalTo(true))
    assertThat(result(arrayOf("a==b", "b!=c", "c==a")), equalTo(false))
    assertThat(result(arrayOf("c==c", "b==d", "x!=y")), equalTo(true))
}

class SatisfiabilityOfEqualityEquations {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun equationsPossible(equations: Array<String>): Boolean {
            val parent = IntArray(26) { it }
            fun find(idx: Int): Int {
                var idx = idx
                while (parent[idx] != idx) {
                    parent[idx] = parent[parent[idx]]   // flatten
                    idx = parent[idx]
                }
                return idx
            }

            fun union(a: Int, b: Int) {
                parent[find(a)] = find(b)
            }

            for (equation in equations) {
                if (equation[1] == '=') {
                    val a = equation[0] - 'a'
                    val b = equation[3] - 'a'
                    union(a, b)
                }
            }
            for (equation in equations) {
                if (equation[1] == '!') {
                    val a = equation[0] - 'a'
                    val b = equation[3] - 'a'
                    if (find(a) == find(b)) return false
                }
            }
            return true
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}