package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DBooleanArray
import util.to1DIntArray

//1018 可被 5 整除的二进制前缀
/* [0,1,1] */

fun main() {
    val result = BinaryPrefixDivisibleBy5.Solution()::prefixesDivBy5
    assertThat(result("[0,1,1]".to1DIntArray()), equalTo("[true,false,false]".to1DBooleanArray()))
    assertThat(result("[1,1,1]".to1DIntArray()), equalTo("[false,false,false]".to1DBooleanArray()))
    assertThat(
        result("[0,1,1,1,1,1]".to1DIntArray()),
        equalTo("[true,false,false,false,true,false]".to1DBooleanArray())
    )
    assertThat(result("[1,1,1,0,1]".to1DIntArray()), equalTo("[false,false,false,false,false]".to1DBooleanArray()))
}

class BinaryPrefixDivisibleBy5 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun prefixesDivBy5(A: IntArray): BooleanArray {
            val res = BooleanArray(A.size)
            var prev = A[0] % 5
            res[0] = prev == 0
            for (i in 1 until A.size) {
                prev = (prev * 2 + A[i]) % 5
                res[i] = prev == 0
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}