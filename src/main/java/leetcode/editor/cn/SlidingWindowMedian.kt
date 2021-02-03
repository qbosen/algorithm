package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to1DDoubleArray
import util.to1DIntArray
import java.util.*
import kotlin.collections.HashMap

//480 滑动窗口中位数
/* [1,3,-1,-3,5,3,6,7],3 */

fun main() {
    val result = SlidingWindowMedian.Solution()::medianSlidingWindow
    assertThat(result("[1,3,-1,-3,5,3,6,7]".to1DIntArray(), 3), equalTo("[1,-1,-1,3,5,6]".to1DDoubleArray()))
    assertThat(result("[2147483647,2147483647]".to1DIntArray(), 2), equalTo("[2147483647.0]".to1DDoubleArray()))
    assertThat(
        result("[2147483647,1,2,3,4,5,6,7,2147483647]".to1DIntArray(), 2),
        equalTo("[1073741824.0,1.5,2.5,3.5,4.5,5.5,6.5,1073741827.0]".to1DDoubleArray())
    )
    assertThat(
        result(
            "[-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648]".to1DIntArray(),
            3
        ),
        equalTo("[-2147483648.0,-2147483648.0,-2147483648.0,-2147483648.0,-2147483648.0,2147483647.0,2147483647.0,2147483647.0,2147483647.0,2147483647.0,-2147483648.0]".to1DDoubleArray())
    )
}

class SlidingWindowMedian {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private class Window(private val n: Int) {
            private val delete = HashMap<Int, Int>()
            private val small = PriorityQueue<Int> { a, b -> b.compareTo(a) }    // 最大堆
            private var smallSize = 0
            private val large = PriorityQueue<Int> { a, b -> a.compareTo(b) }    // 最小堆
            private var largeSize = 0

            fun insert(i: Int) {
                if (small.isEmpty() || i <= small.peek()) {
                    small.offer(i)
                    smallSize++
                } else {
                    large.offer(i)
                    largeSize++
                }
                balance()
            }

            fun erase(i: Int) {
                delete.compute(i) { _, v -> (v ?: 0) + 1 }
                if (i > small.peek()) {
                    largeSize--
                    if (i == large.peek()) prune(large)
                } else {
                    smallSize--
                    if (i == small.peek()) prune(small)
                }

                balance()
            }

            private fun balance() {
                // 需要修正的情况：small比large多两个， large比small多一个
                when {
                    smallSize > largeSize + 1 -> {
                        large.offer(small.poll())
                        smallSize--
                        largeSize++
                        prune(small)
                    }
                    smallSize < largeSize -> {
                        small.offer(large.poll())
                        largeSize--
                        smallSize++
                        prune(large)
                    }
                }
            }

            private fun prune(heap: PriorityQueue<Int>) {
                // 修改的是应该被删除的元素，不需要动size
                while (delete.getOrDefault(heap.peek(), 0) > 0) {
                    delete.compute(heap.poll()) { _, v -> v!! - 1 }
                }
            }

            fun median(): Double {
                return if (n and 1 == 1) small.peek().toDouble() else (small.peek().toDouble() + large.peek()) / 2.0
            }
        }

        fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
            val window = Window(k)
            for (i in 0 until k - 1) {
                window.insert(nums[i])
            }
            val res = DoubleArray(nums.size - k + 1)
            for (i in res.indices) {
                window.insert(nums[i + k - 1])
                res[i] = window.median()
                window.erase(nums[i])
            }

            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}