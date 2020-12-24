package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray
import java.util.Arrays


//135 分发糖果
/* [1,0,2] */

fun main() {
    val result = Candy.Solution()::candy
    assertThat(result("[1,0,2]".to1DIntArray()), equalTo(5))
    assertThat(result("[1,2,2]".to1DIntArray()), equalTo(4))
}

class Candy {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun candy(ratings: IntArray): Int {
            val l2r = IntArray(ratings.size)
            val r2l = IntArray(ratings.size)
            Arrays.fill(l2r, 1)
            Arrays.fill(r2l, 1)
            for (i in 1 until ratings.size) {
                if (ratings[i] > ratings[i - 1]) l2r[i] = l2r[i - 1] + 1
            }
            for (i in ratings.lastIndex - 1 downTo 0) {
                if (ratings[i] > ratings[i + 1]) r2l[i] = r2l[i + 1] + 1
            }
            var sum = 0
            for (i in ratings.indices) {
                sum += Math.max(l2r[i], r2l[i])
            }
            return sum
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}