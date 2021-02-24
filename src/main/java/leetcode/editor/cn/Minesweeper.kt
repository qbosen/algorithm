package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray
import util.to2DCharArray

// 扫雷游戏
// 529
/* [["E","E","E","E","E"],["E","E","M","E","E"],["E","E","E","E","E"],["E","E","E","E","E"]],[3,0] */

fun main() {
    val result = Minesweeper.Solution()::updateBoard
    assertThat(result("""
[["E","E","E","E","E"],
 ["E","E","M","E","E"],
 ["E","E","E","E","E"],
 ["E","E","E","E","E"]]""".to2DCharArray(), "[3,0]".to1DIntArray()), equalTo("""
[["B","1","E","1","B"],
 ["B","1","M","1","B"],
 ["B","1","1","1","B"],
 ["B","B","B","B","B"]]
""".to2DCharArray()))
    assertThat(result("""
[["B", "1", "E", "1", "B"],
 ["B", "1", "M", "1", "B"],
 ["B", "1", "1", "1", "B"],
 ["B", "B", "B", "B", "B"]]""".to2DCharArray(), "[1,2]".to1DIntArray()), equalTo("""
[["B", "1", "E", "1", "B"],
 ["B", "1", "X", "1", "B"],
 ["B", "1", "1", "1", "B"],
 ["B", "B", "B", "B", "B"]]
""".to2DCharArray()))
}

class Minesweeper {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun updateBoard(board: Array<CharArray>, click: IntArray): Array<CharArray> {
            fun doClick(x: Int, y: Int) {
                when (board[x][y]) {
                    'M' -> {
                        board[x][y] = 'X'
                        return
                    }
                    'E' -> {
                        val spread = ArrayList<Pair<Int, Int>>(8)
                        var mineCount = 0
                        for (dx in -1..1) {
                            for (dy in -1..1) {
                                val xx = x + dx
                                val yy = y + dy
                                if ((dx != 0 || dy != 0) && xx in board.indices && yy in board[0].indices) {
                                    when (board[xx][yy]) {
                                        'M', 'X' -> mineCount++
                                        'E' -> spread.add(xx to yy)
                                    }
                                }
                            }
                        }
                        if (mineCount == 0) {
                            board[x][y] = 'B'
                            spread.forEach { doClick(it.first, it.second) }
                        } else {
                            board[x][y] = '0' + mineCount
                        }
                    }
                }
            }

            doClick(click[0], click[1])
            return board
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}