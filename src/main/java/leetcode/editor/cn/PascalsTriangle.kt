package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntList
import java.util.*
import kotlin.collections.ArrayList

// 118 杨辉三角
/* 5 */

fun main() {
    val result = PascalsTriangle.Solution()::generate
    val expect = """[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]""".to2DIntList()
    assertThat(result(5), equalTo(expect))
}

class PascalsTriangle {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun generate(numRows: Int): List<List<Int>> {
            val res = LinkedList<List<Int>>()
            for (i in 0 until numRows) {
                val row = ArrayList<Int>(i + 1)
                for (j in 0..i) {
                    if (j == 0 || j == i) {
                        row.add(1)
                    } else {
                        row.add(res[i - 1][j - 1] + res[i - 1][j])
                    }
                }
                res.add(row)
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}