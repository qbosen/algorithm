package leetcode.editor.cn;

import util.CharUtil;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        String input = "[[\"1\",\"1\",\"1\"],[\"0\",\"1\",\"0\"],[\"1\",\"1\",\"1\"]]";
        char[][] param = CharUtil.parse2D4String(input);
        System.out.println(solution.numIslands(param));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[][] grid;
        int R;
        int C;

        public int numIslands(char[][] grid) {
            this.grid = grid;
            this.R = grid.length;
            if (R == 0) return 0;
            this.C = grid[0].length;
            if (C == 0) return 0;

            int result = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (grid[i][j] == '1') {
                        result++;
                        infect(i, j);
                    }
                }
            }
            return result;
        }


        public void infect(int x, int y) {
            if (grid[x][y] != '1') return;

            grid[x][y] = '2';

            if (x - 1 >= 0)
                infect(x - 1, y);
            if (x + 1 < R)
                infect(x + 1, y);
            if (y - 1 >= 0)
                infect(x, y - 1);
            if (y + 1 < C)
                infect(x, y + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}