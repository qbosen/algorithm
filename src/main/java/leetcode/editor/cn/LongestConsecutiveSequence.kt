package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

// 最长连续序列
// 128
/* [100,4,200,1,3,2] */

fun main() {
    val result = LongestConsecutiveSequence.Solution()::longestConsecutive
    assertThat(result("[100,4,200,1,3,2]".to1DIntArray()), equalTo(4))
}

class LongestConsecutiveSequence {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun longestConsecutive(nums: IntArray): Int {
            val set = HashSet<Int>(nums.size)
            nums.forEach { set.add(it) }
            var res = 0
            for (i in set) {
                if (!set.contains(i - 1)) {
                    var count = 1
                    var curr = i
                    while (set.contains(curr + 1)) {
                        curr++
                        count++
                    }
                    res = Math.max(res, count)
                }
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}