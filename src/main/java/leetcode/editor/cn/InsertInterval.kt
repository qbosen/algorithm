package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray
import util.to2DIntArray
import java.util.*


// 57 插入区间
/* [[1,3],[6,9]],[2,5] */

fun main() {
    val result = InsertInterval.Solution()::insert
    assertThat(result("[[1,3],[6,9]]".to2DIntArray(), "[2,5]".to1DIntArray()), equalTo("[[1,5],[6,9]]".to2DIntArray()))
    assertThat(result("[[1,2],[3,5],[6,7],[8,10],[12,16]]".to2DIntArray(), "[4,8]".to1DIntArray()), equalTo("[[1,2],[3,10],[12,16]]".to2DIntArray()))
}

class InsertInterval {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
            var left = newInterval[0]
            var right = newInterval[1]
            var placed = false
            val ansList: MutableList<IntArray> = ArrayList()
            for (interval in intervals) {
                when {
                    interval[0] > right -> {
                        // 在插入区间的右侧且无交集
                        if (!placed) {
                            ansList.add(intArrayOf(left, right))
                            placed = true
                        }
                        ansList.add(interval)
                    }
                    interval[1] < left -> {
                        // 在插入区间的左侧且无交集
                        ansList.add(interval)
                    }
                    else -> {
                        // 与插入区间有交集，计算它们的并集
                        left = Math.min(left, interval[0])
                        right = Math.max(right, interval[1])
                    }
                }
            }
            if (!placed) {
                ansList.add(intArrayOf(left, right))
            }

            return Array(ansList.size) { ansList[it] }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}