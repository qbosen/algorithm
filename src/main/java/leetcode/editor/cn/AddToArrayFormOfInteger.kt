package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray
import java.util.*

//989 数组形式的整数加法
/* [1,2,0,0],34 */

fun main() {
    val result = AddToArrayFormOfInteger.Solution()::addToArrayForm
    assertThat(result("[1,2,0,0]".to1DIntArray(), 34), equalTo("[1,2,3,4]".to1DIntArray().toList()))
    assertThat(result("[2,7,4]".to1DIntArray(), 181), equalTo("[4,5,5]".to1DIntArray().toList()))
    assertThat(result("[2,7,4]".to1DIntArray(), 1029), equalTo("[1,3,0,3]".to1DIntArray().toList()))
    assertThat(
        result("[9,9,9,9,9,9,9,9,9,9]".to1DIntArray(), 1),
        equalTo("[1,0,0,0,0,0,0,0,0,0,0]".to1DIntArray().toList())
    )
}

class AddToArrayFormOfInteger {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun addToArrayForm(A: IntArray, K: Int): List<Int> {
            val res = LinkedList<Int>()
            var next = K
            for (i in A.lastIndex downTo 0) {
                val s = A[i] + next
                res.addFirst(s % 10)
                next = s / 10
            }
            while (next != 0) {
                res.addFirst(next % 10)
                next /= 10
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}