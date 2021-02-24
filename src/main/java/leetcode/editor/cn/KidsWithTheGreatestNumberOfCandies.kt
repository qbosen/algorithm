package leetcode.editor.cn

import org.junit.Assert.assertArrayEquals
import util.to1DIntArray

// 拥有最多糖果的孩子
// 1431
/* [2,3,5,1,3],3 */

fun main() {
    val result = KidsWithTheGreatestNumberOfCandies.Solution()::kidsWithCandies
    assertArrayEquals(result("[2,3,5,1,3]".to1DIntArray(), 3), booleanArrayOf(true, true, true, false, true))
    assertArrayEquals(result("[4,2,1,1,2]".to1DIntArray(), 1), booleanArrayOf(true, false, false, false, false))
}

class KidsWithTheGreatestNumberOfCandies {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun kidsWithCandies(candies: IntArray, extraCandies: Int): BooleanArray {
            var max = 0
            for (i in candies.indices) {
                max = Math.max(max, candies[i])
                candies[i] += extraCandies
            }
            return BooleanArray(candies.size) { candies[it] >= max }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}