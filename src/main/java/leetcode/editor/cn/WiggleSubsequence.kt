package leetcode.editor.cn
import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

// 376 摆动序列
/* [1,7,4,9,2,5] */

fun main() {
    val result = WiggleSubsequence.Solution()::wiggleMaxLength
    assertThat(result("[1,7,4,9,2,5]".to1DIntArray()), equalTo( 6))
    assertThat(result("[1,17,5,10,13,15,10,5,16,8]".to1DIntArray()), equalTo( 7))
    assertThat(result("[1,2,3,4,5,6,7,8,9]".to1DIntArray()), equalTo( 2))
}

class WiggleSubsequence{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun wiggleMaxLength(nums: IntArray): Int {
        val n: Int = nums.size
        if (n < 2) {
            return n
        }
        val up = IntArray(n)
        val down = IntArray(n)
        up[0] = 1.also { down[0] = it }
        for (i in 1 until n) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1)
                down[i] = down[i - 1]
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1]
                down[i] = Math.max(up[i - 1] + 1, down[i - 1])
            } else {
                up[i] = up[i - 1]
                down[i] = down[i - 1]
            }
        }
        return Math.max(up[n - 1], down[n - 1])

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}