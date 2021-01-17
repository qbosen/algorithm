package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntArray

// 缀点成线
// 1232
/* [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]] */

fun main() {
    val result = CheckIfItIsAStraightLine.Solution()::checkStraightLine
    assertThat(result("[[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]".to2DIntArray()), equalTo(true))
    assertThat(result("[[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]".to2DIntArray()), equalTo(false))
}

class CheckIfItIsAStraightLine {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
            val n = coordinates.size
            for (i in 1 until coordinates.lastIndex) {
                if ((coordinates[i][0] - coordinates[0][0]) *
                        (coordinates[i][1] - coordinates[n - 1][1]) !=
                        (coordinates[i][1] - coordinates[0][1]) *
                        (coordinates[i][0] - coordinates[n - 1][0])
                )
                    return false
            }
            return true
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}