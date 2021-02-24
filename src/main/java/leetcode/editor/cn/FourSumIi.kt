package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

//454 四数相加 II
/* [1,2],[-2,-1],[-1,2],[0,2] */

fun main() {
    val result = FourSumIi.Solution()::fourSumCount
    assertThat(result("[1,2]".to1DIntArray(), "[-2,-1]".to1DIntArray(), "[-1,2]".to1DIntArray(), "[0,2]".to1DIntArray()), equalTo(2))
    assertThat(result("[-1,-1]".to1DIntArray(), "[-1,1]".to1DIntArray(), "[-1,1]".to1DIntArray(), "[1,-1]".to1DIntArray()), equalTo(6))
}

class FourSumIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
            if (A.isEmpty()) return 0
            val N = A.size
            val ab = HashMap<Int, Int>((N * N / 0.75).toInt() + 1)
            for (a in A) {
                for (b in B) {
                    ab.compute(a + b) { _, v -> if (v == null) 1 else v + 1 }
                }
            }

            var res = 0
            for (c in C) {
                for (d in D) {
                    res += ab.getOrDefault(-c - d, 0)
                }
            }

            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}