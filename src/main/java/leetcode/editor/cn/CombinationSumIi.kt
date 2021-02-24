package leetcode.editor.cn

import org.hamcrest.Matcher
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import util.list2DMatcher
import util.to1DIntArray
import util.to2DIntList
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


// 40 组合总和 II
/* [10,1,2,7,6,1,5],8 */

fun main() {
    val result = CombinationSumIi.Solution()::combinationSum2
    assertThat(result("[10,1,2,7,6,1,5]".to1DIntArray(), 8), list2DMatcher("[[1,7],[1,2,5],[2,6],[1,1,6]]".to2DIntList()))
    assertThat(result("[2,5,2,1,2]".to1DIntArray(), 5), list2DMatcher("[[1,2,2],[5]]".to2DIntList()))
}

class CombinationSumIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
            // 根据count计数的最小堆
            val frequency = PriorityQueue<Pair<Int, Int>> { a, b -> if (a.second == b.second) b.first - a.first else a.second - b.second }
            val fMap = HashMap<Int, Int>()
            candidates.forEach { i -> fMap.compute(i) { _, v -> if (v == null) 1 else v + 1 } }
            fMap.forEach { (k, v) -> frequency.offer(k to v) }
            val visit = frequency.toList()

            val result = ArrayList<List<Int>>()
            val temp = LinkedList<Int>()
            fun dfs(remind: Int, idx: Int) {
                when {
                    remind == 0 -> result.add(ArrayList(temp))
                    remind < 0 || idx >= visit.size -> return
                    else -> {
                        val pair = visit[idx]
                        for (time in 0..pair.second) {
                            repeat(time) { temp.addLast(pair.first) }
                            dfs(remind - time * pair.first, idx + 1)
                            repeat(time) { temp.removeLast() }
                        }
                    }
                }
            }
            dfs(target, 0)
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}