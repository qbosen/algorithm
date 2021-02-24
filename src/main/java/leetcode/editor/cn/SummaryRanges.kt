package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.listMatcher
import util.to1DIntArray
import util.toStringList
import java.util.*
import java.util.ArrayList


// 228 汇总区间
/* [0,1,2,4,5,7] */

fun main() {
    val result = SummaryRanges.Solution()::summaryRanges
    assertThat(result("[0,1,2,4,5,7]".to1DIntArray()), listMatcher("""["0->2","4->5","7"]""".toStringList()))
    assertThat(result("[0,2,3,4,6,8,9]".to1DIntArray()), listMatcher("""["0","2->4","6","8->9"]""".toStringList()))
    assertThat(result("[]".to1DIntArray()), listMatcher("""[]""".toStringList()))
}

class SummaryRanges {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun summaryRanges(nums: IntArray): List<String> {
            val ret: MutableList<String> = ArrayList()
            var i = 0
            val n: Int = nums.size
            while (i < n) {
                val low = i
                i++
                while (i < n && nums[i] == nums[i - 1] + 1) {
                    i++
                }
                val high = i - 1
                val temp = StringBuffer(nums[low].toString())
                if (low < high) {
                    temp.append("->")
                    temp.append(nums[high].toString())
                }
                ret.add(temp.toString())
            }
            return ret
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}