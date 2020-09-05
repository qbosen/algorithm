package leetcode.editor.cn
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import java.util.*


// 第k个排列
// 60
/* 3,3 */

fun main() {
    val result = PermutationSequence.Solution()::getPermutation
    assertThat(result(3, 3), equalTo("213"))
    assertThat(result(4, 9), equalTo("2314"))
}

class PermutationSequence{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    fun getPermutation(n: Int, k: Int): String {
        var k = k
        val factorial = IntArray(n)
        factorial[0] = 1
        for (i in 1 until n) {
            factorial[i] = factorial[i - 1] * i
        }
        --k
        val ans = StringBuffer()
        val valid = IntArray(n + 1)
        Arrays.fill(valid, 1)
        for (i in 1..n) {
            var order = k / factorial[n - i] + 1
            for (j in 1..n) {
                order -= valid[j]
                if (order == 0) {
                    ans.append(j)
                    valid[j] = 0
                    break
                }
            }
            k %= factorial[n - i]
        }
        return ans.toString()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}