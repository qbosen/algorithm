package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntArray
import java.util.Comparator

import java.util.Arrays


//435 无重叠区间
/* [[1,2]] */

fun main() {
    val result = NonOverlappingIntervals.Solution()::eraseOverlapIntervals
    assertThat(result("[ [1,2] ]".to2DIntArray()), equalTo(0))
    assertThat(result("[ [1,2], [2,3] ]".to2DIntArray()), equalTo(0))
    assertThat(result("[ [1,2], [1,2], [1,2] ]".to2DIntArray()), equalTo(2))
    assertThat(result("[ [1,2], [2,3], [3,4], [1,3] ]".to2DIntArray()), equalTo(1))
}

class NonOverlappingIntervals {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
            if (intervals.isEmpty()) {
                return 0
            }

            Arrays.sort(intervals) { a, b -> a[1] - b[1] }

            val n: Int = intervals.size
            var right = intervals[0][1]
            var ans = 1
            for (i in 1 until n) {
                if (intervals[i][0] >= right) {
                    ++ans
                    right = intervals[i][1]
                }
            }
            return n - ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}