package leetcode.editor.cn
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 秋叶收藏集 LCP 19
/* "rrryyyrryyyrr" */

fun main() {
    val result = UlBDOe.Solution()::minimumOperations
    assertThat(result("rrryyyrryyyrr"), equalTo(2))
}

class UlBDOe{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minimumOperations(leaves: String): Int {
        val n: Int = leaves.length
        val f = Array(n) { IntArray(3) }
        f[0][0] = if (leaves[0] == 'y') 1 else 0
        f[0][1] = Int.MAX_VALUE.also { f[1][2] = it }.also { f[0][2] = it }
        for (i in 1 until n) {
            val isRed = if (leaves[i] == 'r') 1 else 0
            val isYellow = if (leaves[i] == 'y') 1 else 0
            f[i][0] = f[i - 1][0] + isYellow
            f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + isRed
            if (i >= 2) {
                f[i][2] = Math.min(f[i - 1][1], f[i - 1][2]) + isYellow
            }
        }
        return f[n - 1][2]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}