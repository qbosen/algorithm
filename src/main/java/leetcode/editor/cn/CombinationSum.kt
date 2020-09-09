package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import util.to1DIntArray
import util.to2DIntList

// 39 组合总和
/* [2,3,6,7],7 */

fun main() {
    val result = CombinationSum.Solution()::combinationSum
    val expect = "[[7],[2,2,3]]".to2DIntList()
    assertThat(result("[2,3,6,7]".to1DIntArray(), 7), allOf(hasSize(expect.size), containsInAnyOrder(expect.map { equalTo(it) })))
}

class CombinationSum {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
            val result = ArrayList<List<Int>>()
            val temp = IntArray(candidates.size)
            val resultHash = HashSet<Int>()
            fun hashTemp(): Int {
                val base = 503 // target+1 最多501，最近的素数是503
                var hash = 0
                for (i in temp) {
                    hash = hash * base + i
                }
                return hash
            }

            fun find(sum: Int) {
                when {
                    sum == target -> {
                        val hash = hashTemp()
                        if (!resultHash.contains(hash)) {
                            resultHash.add(hash)
                            val list = ArrayList<Int>()
                            temp.mapIndexed { idx, v -> repeat(v) { list.add(candidates[idx]) } }
                            result.add(list)
                        }
                    }
                    sum > target -> Unit
                    else -> {
                        for (i in candidates.indices) {
                            temp[i]++
                            find(sum + candidates[i])
                            temp[i]--
                        }
                    }
                }
            }

            find(0)
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}