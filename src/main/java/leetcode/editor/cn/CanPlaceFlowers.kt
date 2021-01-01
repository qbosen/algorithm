package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

// 605 种花问题
/* [1,0,0,0,1],1 */

fun main() {
    val result = CanPlaceFlowers.Solution()::canPlaceFlowers
    assertThat(result("[1,0,0,0,1]".to1DIntArray(), 1), equalTo(true))
    assertThat(result("[1,0,0,0,1]".to1DIntArray(), 2), equalTo(false))
}

class CanPlaceFlowers {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
            var n = n
            for (i in flowerbed.indices) {
                if (n == 0) return true
                if (flowerbed[i] == 0 &&
                    (i == 0 || flowerbed[i - 1] == 0) &&
                    (i == flowerbed.lastIndex || flowerbed[i + 1] == 0)
                ) {
                    flowerbed[i] = 1
                    n--
                }
            }
            return n == 0
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}