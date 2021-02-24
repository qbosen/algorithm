package leetcode.editor.cn
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray
import java.lang.RuntimeException
import java.util.HashMap

// 两数之和
// 1
/* [2,7,11,15],9 */

fun main() {
    val result = TwoSum2.Solution()::twoSum
    assertThat(result("[2,7,11,15]".to1DIntArray(), 9), equalTo(intArrayOf(0, 1)))
}

class TwoSum2{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int,Int>()
        for (i in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement)) {
                return intArrayOf(map[complement]!!, i)
            }
            map[nums[i]] = i
        }
        throw RuntimeException()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}