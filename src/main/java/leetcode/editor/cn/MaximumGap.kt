package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray

//164 最大间距
/* [3,6,9,1] */

fun main() {
    val result = MaximumGap.Solution()::maximumGap
    assertThat(result("[3,6,9,1]".to1DIntArray()), equalTo(3))
    assertThat(result("[10]".to1DIntArray()), equalTo(0))
    assertThat(result("[1,1,1,1,1,5,5,5,5,5]".to1DIntArray()), equalTo(4))
    assertThat(result("[15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740]".to1DIntArray()), equalTo(2901))
}

class MaximumGap {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maximumGap(nums: IntArray): Int {
            if (nums.size < 2) return 0
            var min = Int.MAX_VALUE
            var max = Int.MIN_VALUE
            for (num in nums) {
                if (num < min) min = num
                if (num > max) max = num
            }
            val step = Math.max(1, (max - min) / (nums.size - 1))
            val bucketSize = (max - min) / step + 1
            val buckets = Array(bucketSize) { IntArray(2) { -1 } }

            for (num in nums) {
                val idx = (num - min) / step
                if (buckets[idx][0] == -1) {
                    buckets[idx][0] = num
                    buckets[idx][1] = num
                } else {
                    buckets[idx][0] = Math.min(buckets[idx][0], num)
                    buckets[idx][1] = Math.max(buckets[idx][1], num)
                }
            }

            var prevMax = -1
            var res = 0
            for (scope in buckets) {
                if (scope[0] == -1) continue
                if (prevMax != -1) {
                    res = Math.max(res, scope[0] - prevMax)
                }
                prevMax = scope[1]
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}