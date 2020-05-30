package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray
import java.util.*


// 柱状图中最大的矩形
// 84
/* [2,1,5,6,2,3] */

fun main() {
    val result = LargestRectangleInHistogram.Solution()::largestRectangleArea
    assertThat(result("[2,1,5,6,2,3]".to1DIntArray()), equalTo(10))
}

class LargestRectangleInHistogram{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var len = heights.size
        if (len == 0) {
            return 0
        }
        if (len == 1) {
            return heights[0]
        }

        var area = 0
        val newHeights = IntArray(len + 2)
        for (i in 0 until len) {
            newHeights[i + 1] = heights[i]
        }
        len += 2

        val stack: Deque<Int> = ArrayDeque()
        stack.addLast(0)

        for (i in 1 until len) {
            while (newHeights[stack.peekLast()] > newHeights[i]) {
                val height = newHeights[stack.removeLast()]
                val width = i - stack.peekLast() - 1
                area = Math.max(area, width * height)
            }
            stack.addLast(i)
        }
        return area

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}