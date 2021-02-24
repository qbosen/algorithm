package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.list2DMatcher
import util.to1DIntArray
import util.to2DIntList
import java.util.*
import kotlin.collections.ArrayList

// 子集
// 78
/* [1,2,3] */

fun main() {
    val result = Subsets.Solution()::subsets
    assertThat(result("[1,2,3]".to1DIntArray()), list2DMatcher("[[3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[]]".to2DIntList()))
}

class Subsets {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun subsets(nums: IntArray): List<List<Int>> {
            val result = ArrayList<List<Int>>()
            val temp = LinkedList<Int>()
            fun dfs(idx: Int) {
                if (idx == nums.size) {
                    result.add(ArrayList(temp))
                    return
                }
                temp.addLast(nums[idx])
                dfs(idx + 1)
                temp.removeAt(temp.lastIndex)
                dfs(idx + 1)

            }
            dfs(0)
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}