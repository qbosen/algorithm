package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import util.to1DIntArray
import java.util.*
import kotlin.collections.ArrayList

// 三数之和
// 15
/* [-1,0,1,2,-1,-4] */

fun main() {
    val result = ThreeSum.Solution()::threeSum
    assertThat(result("[-1,0,1,2,-1,-4]".to1DIntArray()), containsInAnyOrder(listOf(-1, 0, 1), listOf(-1, -1, 2)))
}

class ThreeSum {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun threeSum(nums: IntArray): List<List<Int>> {
            val res = ArrayList<List<Int>>()
            if (nums.size < 3) return res
            Arrays.sort(nums)
            for (i in nums.indices) {
                if (nums[i] > 0) break
                if (i > 0 && nums[i] == nums[i - 1]) continue
                var l = i + 1
                var r = nums.lastIndex
                while (l < r) {
                    val sum = nums[i] + nums[l] + nums[r]
                    when {
                        sum == 0 -> {
                            res.add(listOf(nums[i], nums[l], nums[r]))
                            while (l < r && nums[l] == nums[l + 1]) l++
                            while (l < r && nums[r] == nums[r - 1]) r--
                            l++
                            r--
                        }
                        sum < 0 -> l++
                        sum > 0 -> r--
                    }
                }
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}