package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to2DCharArray

// 37 解数独
/* [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]] */

fun main() {
    val result = SudokuSolver.Solution()::solveSudoku
    val board = """
[["5","3",".",".","7",".",".",".","."],
["6",".",".","1","9","5",".",".","."],
[".","9","8",".",".",".",".","6","."],
["8",".",".",".","6",".",".",".","3"],
["4",".",".","8",".","3",".",".","1"],
["7",".",".",".","2",".",".",".","6"],
[".","6",".",".",".",".","2","8","."],
[".",".",".","4","1","9",".",".","5"],
[".",".",".",".","8",".",".","7","9"]]""".trimMargin().to2DCharArray()
    val expect = """
[["5","3","4","6","7","8","9","1","2"],
["6","7","2","1","9","5","3","4","8"],
["1","9","8","3","4","2","5","6","7"],
["8","5","9","7","6","1","4","2","3"],
["4","2","6","8","5","3","7","9","1"],
["7","1","3","9","2","4","8","5","6"],
["9","6","1","5","3","7","2","8","4"],
["2","8","7","4","1","9","6","3","5"],
["3","4","5","2","8","6","1","7","9"]]""".trimIndent().to2DCharArray()
    assertThat(board.apply(result), equalTo(expect))
}

class SudokuSolver {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun solveSudoku(board: Array<CharArray>): Unit {
            // 行 列 块，每一个int表示了1-9个bit的状态
            val maps = Triple(IntArray(9), IntArray(9), IntArray(9))
            // 待确定的
            val list = ArrayList<Pair<Int, Int>>()
            var valid = false
            fun flip(i: Int, j: Int, n: Int) {
                val nn = 1 shl n
                maps.first[i] = maps.first[i] xor nn
                maps.second[j] = maps.second[j] xor nn
                val k = i / 3 * 3 + j / 3
                maps.third[k] = maps.third[k] xor nn
            }


            for (i in board.indices) {
                for (j in board[0].indices) {
                    when (board[i][j]) {
                        '.' -> list.add(i to j)
                        else -> flip(i, j, board[i][j] - '1')
                    }
                }
            }

            if (list.isEmpty()) return

            fun available(i: Int, j: Int): Int = (maps.first[i] or maps.second[j] or maps.third[i / 3 * 3 + j / 3]).inv() and 0x1ff
            fun dfs(k: Int) {
                if (k == list.size) {
                    valid = true
                    return
                }
                val (i, j) = list[k]
                var ava = available(i, j)
                while (!valid && ava != 0) {
                    val lastN = ava and (-ava)  // 最后一个1
                    ava = ava and (ava - 1)  // 删掉最后一个1
                    val n = Integer.bitCount(lastN - 1) // 最后一个1的idx
                    flip(i, j, n)
                    board[i][j] = '1' + n
                    dfs(k + 1)
                    flip(i, j, n)
                }
            }

            dfs(0)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}