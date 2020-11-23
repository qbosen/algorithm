package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntArray
import java.util.*

//452 用最少数量的箭引爆气球
/* [[10,16],[2,8],[1,6],[7,12]] */

fun main() {
    val result = MinimumNumberOfArrowsToBurstBalloons.Solution()::findMinArrowShots
    assertThat(result("[[10,16],[2,8],[1,6],[7,12]]".to2DIntArray()), equalTo(2))
    assertThat(result("[[1,2],[3,4],[5,6],[7,8]]".to2DIntArray()), equalTo(4))
    assertThat(result("[[1,2],[2,3],[3,4],[4,5]]".to2DIntArray()), equalTo(2))
    assertThat(result("[[1,2]]".to2DIntArray()), equalTo(1))
    assertThat(result("[[2,3],[2,3]]".to2DIntArray()), equalTo(1))
    assertThat(result("[[-2147483646,-2147483645],[2147483646,2147483647]]".to2DIntArray()), equalTo(2))
}

class MinimumNumberOfArrowsToBurstBalloons {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findMinArrowShots(points: Array<IntArray>): Int {
            if (points.isEmpty()) return 0

            val comparator = Comparator<IntArray> { a, b -> a[1].compareTo(b[1]) }
            Arrays.sort(points, comparator)

            var pos = points[0][1]
            var ans = 1
            for (balloon in points) {
                if (balloon[0] > pos) {   // 无法涵盖，需要射箭
                    pos = balloon[1]
                    ans++
                }
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}