package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

// 697 数组的度
/* [1,2,2,3,1] */

fun main() {
    val result = DegreeOfAnArray.Solution()::findShortestSubArray
    assertThat(result("[1,2,2,3,1]".to1DIntArray()), equalTo(2))
    assertThat(result("[1,2,2,3,1,4,2]".to1DIntArray()), equalTo(6))
}

class DegreeOfAnArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findShortestSubArray(nums: IntArray): Int {
            val map = HashMap<Int, IntArray>()
            for (i in nums.indices) {
                val key = nums[i]
                if (map.containsKey(key)) {
                    map[key]!![0]++
                    map[key]!![2] = i
                } else {
                    map[key] = intArrayOf(1, i, i)
                }
            }

            var degree = 0
            var res = 0

            for (v in map.values) {
                val l = v[2] - v[1] + 1
                when {
                    v[0] > degree -> {
                        degree = v[0]
                        res = l
                    }
                    v[0] == degree -> {
                        if (l < res) res = l
                    }
                }
            }

            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}