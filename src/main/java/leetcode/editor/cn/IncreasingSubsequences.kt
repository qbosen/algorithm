package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import util.to1DIntArray
import util.to2DIntList

// 递增子序列
// 491
/* [4,6,7,7] */

fun main() {
    val result = IncreasingSubsequences.Solution()::findSubsequences
    val expect = "[[4,6],[4,7],[4,6,7],[4,6,7,7],[6,7],[6,7,7],[7,7],[4,7,7]]".to2DIntList()
    assertThat(result("[4,6,7,7]".to1DIntArray()), allOf(hasSize(expect.size), containsInAnyOrder(expect.map { equalTo(it) })))
}

class IncreasingSubsequences {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findSubsequences(nums: IntArray): List<List<Int>> {
            val temp = ArrayList<Int>()
            val set = HashSet<Int>()
            val ans = ArrayList<List<Int>>()
            val N = nums.size

            fun findSubsequences(mask: Int) {
                temp.clear()
                var mask = mask
                for (i in 0 until N) {    // 每一个bit
                    if (mask and 1 != 0) {
                        temp.add(nums[i])
                    }
                    mask = mask shr 1
                }
            }

            fun checkTemp(): Boolean {
                for (i in 0 until temp.lastIndex) {
                    if (temp[i] > temp[i + 1]) return false
                }
                return temp.size >= 2
            }

            fun hashTemp(): Int {
                // 大于201的素数为基 211
                val base = 211
                var hash = 0
                for (v in temp) {
                    hash = (hash * base) + (v + 101)
                }
                return hash
            }
            for (i in 0 until (1 shl N)) {  // 2^n 种可能
                findSubsequences(i)
                if (checkTemp()) {
                    val hashCode = hashTemp()
                    if (!set.contains(hashCode)) {
                        set.add(hashCode)
                        ans.add(ArrayList(temp))
                    }
                }
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}