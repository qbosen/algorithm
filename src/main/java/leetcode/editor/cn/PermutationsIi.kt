package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import util.list2DMatcher
import util.to1DIntArray
import util.to2DIntList
import java.util.*
import kotlin.collections.ArrayList

// 47 全排列 II
/* [1,1,2] */

fun main() {
    val result = PermutationsIi.Solution()::permuteUnique
    assertThat(result("[1,1,2]".to1DIntArray()), list2DMatcher("""[[1,1,2],[1,2,1],[2,1,1]]""".to2DIntList()))
}

class PermutationsIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun permuteUnique(nums: IntArray): List<List<Int>> {
            val visited = BooleanArray(nums.size)
            val result = ArrayList<List<Int>>()
            val temp = LinkedList<Int>()
            Arrays.sort(nums)

            fun dfs(idx: Int) {
                if (idx == nums.size) {
                    result.add(ArrayList(temp))
                    return
                }
                for (i in nums.indices) {
                    if(visited[i] || (i>0 && nums[i]==nums[i-1] && !visited[i-1]))
                        continue    // 从左往右第一个未填过的数字
                    temp.addLast(nums[i]).also { visited[i] = true }
                    dfs(idx+1)
                    temp.removeLast().also { visited[i] = false }
                }
            }

            dfs(0)
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}