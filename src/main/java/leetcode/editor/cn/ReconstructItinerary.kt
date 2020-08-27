package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to2DStringList
import util.toStringList
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

// 332 重新安排行程
/* [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]] */

fun main() {
    val result = ReconstructItinerary.Solution()::findItinerary
    assertThat(result("""[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]""".to2DStringList()),
            equalTo("""["JFK", "MUC", "LHR", "SFO", "SJC"]""".toStringList()))

    assertThat(result("""[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]""".to2DStringList()),
            equalTo("""["JFK","ATL","JFK","SFO","ATL","SFO"]""".toStringList()))
}

class ReconstructItinerary {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findItinerary(tickets: List<List<String>>): List<String> {
            val graph = HashMap<String, PriorityQueue<String>>()
            val result = ArrayList<String>()
            tickets.forEach { ticket ->
                graph.compute(ticket[0]) { _, v ->
                    (v ?: PriorityQueue()).apply { offer(ticket[1]) }
                }
            }

            fun dfs(src: String) {
                while (graph[src]?.isNotEmpty() == true) {
                    val next = graph[src]!!.poll()
                    dfs(next)
                }
                result.add(src)
            }
            dfs("JFK")
            result.reverse()
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}