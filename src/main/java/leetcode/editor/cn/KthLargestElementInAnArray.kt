package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray

// 数组中的第K个最大元素
// 215
/* [3,2,1,5,6,4],2 */

fun main() {
    val result = KthLargestElementInAnArray.Solution()::findKthLargest
    assertThat(result("[3,2,1,5,6,4]".to1DIntArray(), 2), equalTo(5))
    assertThat(result("[3,2,3,1,2,4,5,5,6]".to1DIntArray(), 4), equalTo(4))
}

class KthLargestElementInAnArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findKthLargest(nums: IntArray, k: Int): Int {
            var heapSize = nums.size
            buildMaxHeap(nums, heapSize)
            for (i in nums.size - 1 downTo nums.size - k + 1) {
                swap(nums, 0, i)
                --heapSize
                maxHeapify(nums, 0, heapSize)
            }
            return nums[0]
        }

        fun buildMaxHeap(a: IntArray, heapSize: Int) {
            for (i in heapSize / 2 downTo 0) {
                maxHeapify(a, i, heapSize)
            }
        }

        fun maxHeapify(a: IntArray, i: Int, heapSize: Int) {
            val l = i * 2 + 1
            val r = i * 2 + 2
            var largest = i
            if (l < heapSize && a[l] > a[largest]) {
                largest = l
            }
            if (r < heapSize && a[r] > a[largest]) {
                largest = r
            }
            if (largest != i) {
                swap(a, i, largest)
                maxHeapify(a, largest, heapSize)
            }
        }

        fun swap(a: IntArray, i: Int, j: Int) {
            val temp = a[i]
            a[i] = a[j]
            a[j] = temp
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}