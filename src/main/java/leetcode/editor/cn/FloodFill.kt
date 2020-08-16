package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntArray
import java.util.*

// 图像渲染
// 733
/* [[1,1,1],[1,1,0],[1,0,1]],1,1,2 */

fun main() {
    val result = FloodFill.Solution()::floodFill
    val value = result("[[1,1,1],[1,1,0],[1,0,1]]".to2DIntArray(), 1, 1, 2)
    assert(Arrays.equals(value, ("[[2,2,2],[2,2,0],[2,0,1]]".to2DIntArray())))
}

class FloodFill {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
            val direction = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
            val targetColor = image[sr][sc]
            if (newColor == targetColor) return image
            val queue = LinkedList<Pair<Int, Int>>()
            queue.add(sr to sc)
            image[sr][sc] = newColor

            while (queue.isNotEmpty()) {
                val (x, y) = queue.poll()
                for (direct in direction) {
                    val xx = x + direct.first
                    val yy = y + direct.second
                    if(xx in image.indices && yy in image[0].indices && image[xx][yy] == targetColor){
                        queue.offer(xx to yy)
                        image[xx][yy] = newColor
                    }
                }
            }
            return image
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}