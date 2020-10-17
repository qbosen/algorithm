package leetcode.editor.cn
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

// 52 N皇后 II
/* 4 */

fun main() {
    val result = NQueensIi.Solution()::totalNQueens
    assertThat(result(4), equalTo(2))
}

class NQueensIi{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun totalNQueens(n: Int): Int {
        return solve(n,0,0,0,0)
    }
    fun solve(n: Int, row: Int, columns: Int, diagonals1: Int, diagonals2: Int): Int {
        return if (row == n) {
            1
        } else {
            var count = 0
            var availablePositions = (1 shl n) - 1 and (columns or diagonals1 or diagonals2).inv()
            while (availablePositions != 0) {
                val position = availablePositions and -availablePositions
                availablePositions = availablePositions and availablePositions - 1
                count += solve(n, row + 1, columns or position, diagonals1 or position shl 1, diagonals2 or position shr 1)
            }
            count
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}