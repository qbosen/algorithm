package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray
import java.util.*

//1046 最后一块石头的重量
/* [2,7,4,1,8,1] */

fun main() {
    val result = LastStoneWeight.Solution()::lastStoneWeight
    assertThat(result("[2,7,4,1,8,1]".to1DIntArray()), equalTo(1))
}

class LastStoneWeight {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun lastStoneWeight(stones: IntArray): Int {
            val heap = PriorityQueue<Int>(stones.size, { a, b -> b - a }).apply { stones.forEach { add(it) } }
            while (heap.size > 1) {
                heap.offer(Math.abs(heap.poll() - heap.poll()))
            }
            return heap.peek()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}