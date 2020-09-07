package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray
import java.util.*
import kotlin.collections.HashMap

// 347 前 K 个高频元素
/* [1,1,1,2,2,3],2 */

fun main() {
    val result = TopKFrequentElements.Solution()::topKFrequent
    assertThat(result("[1,1,1,2,2,3]".to1DIntArray(), 2), equalTo("[1,2]".to1DIntArray()))
    assertThat(result("[1]".to1DIntArray(), 1), equalTo("[1]".to1DIntArray()))
    assertThat(result("[4,1,-1,2,-1,2,3]".to1DIntArray(), 2), equalTo("[2,-1]".to1DIntArray()))
}

class TopKFrequentElements {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun topKFrequent(nums: IntArray, k: Int): IntArray {
            // 最小堆
            val heap = PriorityQueue(k) { o1: Pair<Int, Int>, o2: Pair<Int, Int> -> o1.second - o2.second }
            val map = HashMap<Int, Int>()
            for (num in nums) {
                val remove = heap.remove(num to map[num])
                val pair = num to map.compute(num) { _, v ->
                    if (v == null) 1 else v + 1
                }!!

                if (remove || heap.size < k) {
                    heap.add(pair)
                } else if (heap.size == k && pair.second > heap.peek().second) {
                    heap.poll()
                    heap.add(pair)
                }
            }
            val result = IntArray(k)
            for (i in k - 1 downTo 0) {
                result[i] = heap.poll().first
            }
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}