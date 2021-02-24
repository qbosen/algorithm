package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import util.list2DMatcher
import util.to2DIntList
import java.util.*
import kotlin.collections.ArrayList

// 216 组合总和 III
/* 3,7 */

fun main() {
    val result = CombinationSumIii.Solution()::combinationSum3
    assertThat(result(3, 7), list2DMatcher("[[1,2,4]]".to2DIntList()))
    assertThat(result(3, 9), list2DMatcher("[[1,2,6],[1,3,5],[2,3,4]]".to2DIntList()))
}

class CombinationSumIii {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun combinationSum3(k: Int, n: Int): List<List<Int>> {
            val result = ArrayList<List<Int>>()
            val temp = LinkedList<Int>()
            fun dfs(idx: Int, remainK: Int, remainN: Int) {
                when {
                    remainN == 0 && remainK == 0 -> result.add(ArrayList(temp))
                    remainN <= 0 || remainK <= 0 -> Unit
                    remainK == 1 -> if (remainN in idx..9) {    //优化
                        temp.addLast(remainN)
                        result.add(ArrayList(temp))
                        temp.removeAt(temp.lastIndex)
                    }
                    else -> {
                        for (i in idx..remainN) {
                            temp.addLast(i)
                            dfs(i + 1, remainK - 1, remainN - i)
                            temp.removeAt(temp.lastIndex)
                        }
                    }
                }
            }

            dfs(1, k, n)
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}