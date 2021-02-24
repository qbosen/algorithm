package leetcode.editor.cn;
// 生命游戏
// 289
// [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]

import util.IntUtil;

import java.util.Arrays;

public class GameOfLife {
    public static void run(Solution solution, String expect, String board) {
        int[][] board_ = IntUtil.parse2DIntArray(board);
        solution.gameOfLife(board_);
        System.out.println(expect + "=" + Arrays.deepToString(board_));
    }

    public static void main(String[] args) {
        Solution solution = new GameOfLife().new Solution();
        run(solution, "[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]", "[[0,1,0],[0,0,1],[1,1,1],[0,0,0]]");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] board = null;
        int R = 0;
        int C = 0;
        int[] d = {-1, 0, 1};

        public void gameOfLife(int[][] board) {
            this.board = board;
            R = board.length;
            C = board[0].length;

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    check(i, j);
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    board[i][j] = board[i][j] >> 2;
                }
            }
        }

        private boolean valid(int i, int j) {
            return i >= 0 && i < R && j >= 0 && j < C && (board[i][j] & 1) == 1;
        }

        private void check(int i, int j) {
            int count = 0;
            for (int dr : d) {
                for (int dc : d) {
                    if (dr == 0 && dc == 0) continue;
                    if (valid(i + dr, j + dc)) count++;
                }
            }

            if ((board[i][j] & 1) == 0) { // 死细胞
                if (count == 3) board[i][j] += 6;
                else board[i][j] += 2;
            } else {
                if (count < 2) board[i][j] += 2;
                else if (count == 2 || count == 3) board[i][j] += 6;
                else board[i][j] += 2;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}