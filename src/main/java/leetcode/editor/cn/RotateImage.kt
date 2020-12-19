package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to2DIntArray

//48 旋转图像
/* [[1,2,3],[4,5,6],[7,8,9]] */

fun main() {
    val result = RotateImage.Solution()::rotate
    assertThat("[[1,2,3],[4,5,6],[7,8,9]]".to2DIntArray().apply(result), equalTo("[[7,4,1],[8,5,2],[9,6,3]]".to2DIntArray()))
    assertThat("[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]".to2DIntArray().apply(result),
            equalTo("[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]".to2DIntArray()))
}

class RotateImage {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun rotate(matrix: Array<IntArray>): Unit {
            val n = matrix.size
            for (i in 0 until n / 2) {
                for (j in 0 until (n + 1) / 2) {
                    val temp = matrix[i][j]
                    matrix[i][j] = matrix[n - j - 1][i]
                    matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1]
                    matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1]
                    matrix[j][n - i - 1] = temp
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}