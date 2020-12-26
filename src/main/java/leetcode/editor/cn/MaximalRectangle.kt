package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DCharArray
import java.util.LinkedList

import java.util.Deque


//85 最大矩形
/* [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]] */

fun main() {
    val result = MaximalRectangle.Solution()::maximalRectangle
    assertThat(
        result("""[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]""".to2DCharArray()),
        equalTo(6)
    )
    assertThat(result("""[]""".to2DCharArray()), equalTo(0))
    assertThat(result("""[["0"]]""".to2DCharArray()), equalTo(0))
    assertThat(result("""[["0","0"]]""".to2DCharArray()), equalTo(0))
    assertThat(result("""[["1"]]""".to2DCharArray()), equalTo(1))
}

class MaximalRectangle {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maximalRectangle(matrix: Array<CharArray>): Int {
            val m: Int = matrix.size
            if (m == 0) {
                return 0
            }
            val n: Int = matrix[0].size
            val left = Array(m) { IntArray(n) }

            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (matrix[i][j] == '1') {
                        left[i][j] = (if (j == 0) 0 else left[i][j - 1]) + 1
                    }
                }
            }

            var ret = 0
            for (j in 0 until n) { // 对于每一列，使用基于柱状图的方法
                val up = IntArray(m)
                val down = IntArray(m)
                val stack: Deque<Int> = LinkedList()
                for (i in 0 until m) {
                    while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                        stack.pop()
                    }
                    up[i] = if (stack.isEmpty()) -1 else stack.peek()
                    stack.push(i)
                }
                stack.clear()
                for (i in m - 1 downTo 0) {
                    while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                        stack.pop()
                    }
                    down[i] = if (stack.isEmpty()) m else stack.peek()
                    stack.push(i)
                }
                for (i in 0 until m) {
                    val height = down[i] - up[i] - 1
                    val area = height * left[i][j]
                    ret = Math.max(ret, area)
                }
            }
            return ret
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}