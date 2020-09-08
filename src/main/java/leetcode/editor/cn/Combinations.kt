package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import util.to2DIntList
import java.util.*
import kotlin.collections.ArrayList

// 77 组合
/* 4,2 */

fun main() {
    val result = Combinations.Solution()::combine
    val expect = "[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]".to2DIntList()
    assertThat(result(4, 2), allOf(hasSize(expect.size), containsInAnyOrder(expect.map { equalTo(it) })))
}

class Combinations {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun combine(n: Int, k: Int): List<List<Int>> {
            val visited = BooleanArray(n + 1)
            val result = ArrayList<List<Int>>()
            val tmp = LinkedList<Int>()

            fun findLastK(s: Int, kk: Int) {
                if (kk == 0) {
                    result.add(ArrayList(tmp))
                    return
                }
                for (i in s..n) {
                    if (!visited[i]) {
                        visited[i] = true
                        tmp.addLast(i)
                        findLastK(i + 1, kk - 1)
                        tmp.removeLast()
                        visited[i] = false
                    }
                }
            }
            findLastK(1, k)
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}