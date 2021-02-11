package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DIntArray
import java.util.*

// 703 数据流中的第 K 大元素
/* ["KthLargest","add","add","add","add","add"],[[3,[4,5,8,2]],[3],[5],[10],[9],[4]] */

fun main() {
    val kth = KthLargestElementInAStream.KthLargest(3, "[4,5,8,2]".to1DIntArray())
    assertThat(4, equalTo(kth.add(3)))
    assertThat(5, equalTo(kth.add(5)))
    assertThat(5, equalTo(kth.add(10)))
    assertThat(9, equalTo(kth.add(8)))
    assertThat(4, equalTo(kth.add(8)))
}

class KthLargestElementInAStream {
    //leetcode submit region begin(Prohibit modification and deletion)
    class KthLargest(val k: Int, nums: IntArray) {
        private val heap = PriorityQueue<Int>()

        init {
            nums.forEach { add(it) }
        }

        fun add(`val`: Int): Int {
            heap.offer(`val`)
            if (heap.size > k) heap.poll()
            return heap.peek()
        }

    }

    /**
     * Your KthLargest object will be instantiated and called as such:
     * var obj = KthLargest(k, nums)
     * var param_1 = obj.add(`val`)
     */
//leetcode submit region end(Prohibit modification and deletion)

}