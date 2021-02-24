package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

//888 公平的糖果棒交换
/* [1,1],[2,2] */

fun main() {
    val result = FairCandySwap.Solution()::fairCandySwap
    assertThat(result("[1,1]".to1DIntArray(), "[2,2]".to1DIntArray()), equalTo("[1,2]".to1DIntArray()))
    assertThat(result("[1,2]".to1DIntArray(), "[2,3]".to1DIntArray()), equalTo("[1,2]".to1DIntArray()))
    assertThat(result("[2]".to1DIntArray(), "[1,3]".to1DIntArray()), equalTo("[2,3]".to1DIntArray()))
    assertThat(result("[1,2,5]".to1DIntArray(), "[2,4]".to1DIntArray()), equalTo("[5,4]".to1DIntArray()))
}

class FairCandySwap {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun fairCandySwap(A: IntArray, B: IntArray): IntArray {
            //y = x - (sa-sb) / 2
            val sa = A.sum()
            var sb = 0
            val set = HashSet<Int>()
            for (i in B) {
                sb += i
                set.add(i)
            }

            val d = (sa - sb) / 2
            for (x in A) {
                val y = x - d
                if (set.contains(y))
                    return intArrayOf(x, y)
            }
            return intArrayOf(-1, -1)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}