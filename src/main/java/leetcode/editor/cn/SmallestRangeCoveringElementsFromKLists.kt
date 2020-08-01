package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to2DIntList
import java.util.*


// 最小区间
// 632
/* [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]] */

fun main() {
    val result = SmallestRangeCoveringElementsFromKLists.Solution()::smallestRange
    assertThat(result("[[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]".to2DIntList()), equalTo( intArrayOf(20,24)))
}

class SmallestRangeCoveringElementsFromKLists{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun smallestRange(nums: List<List<Int>>): IntArray {
        var rangeLeft = 0
        var rangeRight = Int.MAX_VALUE
        var minRange = rangeRight - rangeLeft
        var max = Int.MIN_VALUE
        val k: Int = nums.size
        val next = IntArray(k)
        val priorityQueue = PriorityQueue(Comparator<Int> { i, j -> nums[i][next[i]] - nums[j][next[j]] })
        for (i in 0 until k) {
            priorityQueue.offer(i)
            max = Math.max(max, nums[i][0])
        }
        while (true) {
            val minIndex = priorityQueue.poll()!!
            val curRange = max - nums[minIndex][next[minIndex]]
            if (curRange < minRange) {
                minRange = curRange
                rangeLeft = nums[minIndex][next[minIndex]]
                rangeRight = max
            }
            next[minIndex]++
            if (next[minIndex] == nums[minIndex].size) {
                break
            }
            priorityQueue.offer(minIndex)
            max = Math.max(max, nums[minIndex][next[minIndex]])
        }
        return intArrayOf(rangeLeft, rangeRight)


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}