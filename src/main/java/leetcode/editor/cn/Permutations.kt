package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.factorial
import util.to1DIntArray
import java.util.ArrayDeque

// 全排列
// 46
/* [1,2,3] */

fun main() {
    val result = Permutations.Solution()::permute
    assertThat(result("[1,2,3]".to1DIntArray()), hasSize(3.factorial()))
    assertThat(result("[1,2,3,4,5,6,7,8,9]".to1DIntArray()), hasSize(9.factorial()))

}

class Permutations {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun permute(nums: IntArray): List<List<Int>> {
            val res = ArrayList<ArrayList<Int>>()
            if (nums.isEmpty()) return res
            val path = ArrayDeque<Int>()
            val used = BooleanArray(nums.size)
            dfs(nums, 0, path, res, used)
            return res
        }

        private fun dfs(nums: IntArray, depth: Int, path: ArrayDeque<Int>, res: ArrayList<ArrayList<Int>>, used: BooleanArray) {
            if (depth == nums.size) {
                res.add(ArrayList(path))
                return
            }

            for (i in nums.indices) {
                if (used[i]) continue

                path.addLast(nums[i]).also { used[i] = true }
                dfs(nums, depth + 1, path, res, used)
                path.removeLast().also { used[i] = false }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}