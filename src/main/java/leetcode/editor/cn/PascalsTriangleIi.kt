package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

// 119 杨辉三角 II
/* 3 */

fun main() {
    val result = PascalsTriangleIi.Solution()::getRow
    assertThat(result(3), equalTo("[1,3,3,1]".to1DIntArray().toList()))
}

class PascalsTriangleIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun getRow(rowIndex: Int): List<Int> {
            val res = ArrayList<Int>(rowIndex + 1)
            res.add(1)
            for (i in 1..rowIndex) {
                res.add((res[i - 1].toLong() * (rowIndex - i + 1) / i).toInt())
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}