package leetcode.editor.cn
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray


// 1004 最大连续1的个数 III
/* [1,1,1,0,0,0,1,1,1,1,0],2 */

fun main() {
    val result = MaxConsecutiveOnesIii.Solution()::longestOnes
    assertThat(result("[1,1,1,0,0,0,1,1,1,1,0]".to1DIntArray(),2), equalTo(6 ))
    assertThat(result("[0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]".to1DIntArray(),3), equalTo(10))
}

class MaxConsecutiveOnesIii{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun longestOnes(A: IntArray, K: Int): Int {
        val n = A.size
        var left = 0
        var lsum = 0
        var rsum = 0
        var ans = 0
        for (right in 0 until n) {
            rsum += 1 - A[right]
            while (lsum < rsum - K) {
                lsum += 1 - A[left]
                ++left
            }
            ans = Math.max(ans, right - left + 1)
        }
        return ans

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}