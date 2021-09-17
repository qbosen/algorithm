package top.abosen.leetcode;

import java.util.Arrays;

//[36] 有效的数独
public class ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new ValidSudoku().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            boolean[] visitRow = new boolean[9];
            boolean[] visitCol = new boolean[9];
            for (int i = 0; i < 9; i++) {
                Arrays.fill(visitRow, false);
                Arrays.fill(visitCol, false);
                for (int j = 0; j < 9; j++) {
                    if (!valid(visitRow, board[i][j])) return false;
                    if (!valid(visitCol, board[j][i])) return false;
                }
            }

            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {
                    Arrays.fill(visitRow, false);
                    for (int k = 0; k < 9; k++) {
                        if (!valid(visitRow, board[i + k / 3][j + k % 3])) return false;
                    }
                }
            }
            return true;
        }

        private boolean valid(boolean[] visited, char digit) {
            if (digit == '.') return true;
            int i = digit - '1';
            if (visited[i]) return false;
            visited[i] = true;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}