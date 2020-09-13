package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DCharArray

// 单词搜索
// 79
/* [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],"ABCCED" */

fun main() {
    val result = WordSearch.Solution()::exist
    val board = """[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]""".to2DCharArray()
    assertThat(result(board, "ABCCED"), equalTo(true))
    assertThat(result(board, "SEE"), equalTo(true))
    assertThat(result(board, "ABCD"), equalTo(false))
}

class WordSearch {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun exist(board: Array<CharArray>, word: String): Boolean {
            val visited = Array(board.size) { BooleanArray(board[0].size) }

            fun dfs(i: Int, j: Int, k: Int): Boolean {
                if (k == word.length) return true
                if (i !in (board.indices) || j !in (board[0].indices) || board[i][j] != word[k]) return false
                if (!visited[i][j]) {
                    visited[i][j] = true
                    if (dfs(i + 1, j, k + 1) || dfs(i - 1, j, k + 1) || dfs(i, j + 1, k + 1) || dfs(i, j - 1, k + 1))
                        return true
                    visited[i][j] = false
                }
                return false
            }

            for (i in board.indices) {
                for (j in board[0].indices) {
                    if (dfs(i, j, 0)) return true
                }
            }
            return false
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}