package leetcode.editor.cn
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray
import java.util.*


//659 分割数组为连续子序列
/* [1,2,3,3,4,5] */

fun main() {
    val result = SplitArrayIntoConsecutiveSubsequences.Solution()::isPossible
    assertThat(result("[1,2,3,3,4,5]".to1DIntArray()), equalTo(true))
    assertThat(result("[1,2,3,3,4,4,5,5]".to1DIntArray()), equalTo(true))
    assertThat(result("[1,2,3,4,4,5]".to1DIntArray()), equalTo(false))
}

class SplitArrayIntoConsecutiveSubsequences{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun isPossible(nums: IntArray): Boolean {
        val countMap = HashMap<Int, Int>()
        val endMap = HashMap<Int, Int>()
        for (x in nums) {
            val count = countMap.getOrDefault(x, 0) + 1
            countMap[x] = count
        }
        for (x in nums) {
            val count = countMap.getOrDefault(x, 0)
            if (count > 0) {
                val prevEndCount = endMap.getOrDefault(x - 1, 0)
                if (prevEndCount > 0) {
                    countMap[x] = count - 1
                    endMap[x - 1] = prevEndCount - 1
                    endMap[x] = endMap.getOrDefault(x, 0) + 1
                } else {
                    val count1 = countMap.getOrDefault(x + 1, 0)
                    val count2 = countMap.getOrDefault(x + 2, 0)
                    if (count1 > 0 && count2 > 0) {
                        countMap[x] = count - 1
                        countMap[x + 1] = count1 - 1
                        countMap[x + 2] = count2 - 1
                        endMap[x + 2] = endMap.getOrDefault(x + 2, 0) + 1
                    } else {
                        return false
                    }
                }
            }
        }
        return true
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}