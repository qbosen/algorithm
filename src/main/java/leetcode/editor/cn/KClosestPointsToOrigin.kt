package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntArray
import java.util.*

//973 最接近原点的 K 个点
/* [[1,3],[-2,2]],1 */

fun main() {
    val result = KClosestPointsToOrigin.Solution()::kClosest
    assertThat(result("[[1,3],[-2,2]]".to2DIntArray(), 1), arrayContainingInAnyOrder(*"[[-2,2]]".to2DIntArray()))
    assertThat(result("[[3,3],[5,-1],[-2,4]]".to2DIntArray(), 2), arrayContainingInAnyOrder(*"[[3,3],[-2,4]]".to2DIntArray()))
}

class KClosestPointsToOrigin {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
            // 最大堆, 从大到小
            fun dist(point: IntArray): Int = point[0] * point[0] + point[1] * point[1]
            val comparator = Comparator<IntArray> { a, b -> dist(b) - dist(a) }
            val heap = PriorityQueue<IntArray>(K, comparator)
            for (point in points) {
                if (heap.size < K) heap.offer(point)
                else {
                    if (dist(point) < dist(heap.peek())) {
                        heap.poll()
                        heap.offer(point)
                    }
                }
            }
            return heap.toTypedArray()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}