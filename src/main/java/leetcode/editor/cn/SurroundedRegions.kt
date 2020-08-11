package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to2DCharArray

// 被围绕的区域
// 130
/* [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]] */

fun main() {
    val result = SurroundedRegions.Solution()::solve
    assertThat("""[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]""".to2DCharArray().also(result),
            equalTo("""[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]""".to2DCharArray()))
}

class SurroundedRegions {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun solve(board: Array<CharArray>): Unit {
            if (board.isEmpty() || board[0].isEmpty()) return
            val R = board.size
            val C = board[0].size
            val rRange = 0 until R
            val cRange = 0 until C
            fun isBorder(idx: Int): Boolean {
                if (idx <= 0) return true
                val r = idx / C
                val c = idx - r * C
                return r == 0 || r == R - 1 || c == 0 || c == C - 1
            }

            val uf = IntArray(R * C) { if (isBorder(it)) -it else it }

            fun find(idx: Int): Int {
                val absIdx = if (idx <= 0) -idx else idx
                if (idx == uf[absIdx]) return idx
                val root = find(uf[absIdx])
                uf[absIdx] = if (idx <= 0 && root > 0) -root else root
                return uf[absIdx]
            }

            fun join(a: Int, b: Int) {
                val rootA = find(a)
                val rootB = find(b)
                if (rootA <= 0) {
                    uf[Math.abs(rootB)] = rootA
                } else {
                    uf[rootA] = rootB
                }
            }

            val direction = arrayOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
            for (i in rRange) {
                for (j in cRange) {
                    if (board[i][j] == 'O') { // 查找周围
                        for (direct in direction) {
                            val ii = i + direct.first
                            val jj = j + direct.second
                            if (ii in rRange && jj in cRange && board[ii][jj] == 'O') {
                                join(i * C + j, ii * C + jj)
                            }
                        }
                    }
                }
            }

            for (i in rRange) {
                for (j in cRange) {
                    if (board[i][j] == 'O' && find(i * C + j) > 0) {
                        board[i][j] = 'X'
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}