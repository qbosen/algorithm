package leetcode.editor.cn;

import java.util.*;

//[417] 太平洋大西洋水流问题
/* [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]] */
public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        Solution solution = new PacificAtlanticWaterFlow().new Solution();
        solution.pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m, n;
        int[][] mark, heights;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            m = heights.length;
            n = heights[0].length;
            mark = new int[m][n];
            this.heights = heights;

            for (int i = 0; i < m; i++) {
                dfs(i, 0, 1);
                dfs(i, n - 1, 2);
            }
            for (int j = 0; j < n; j++) {
                dfs(0, j, 1);
                dfs(m - 1, j, 2);
            }

            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mark[i][j] == 3) {
                        res.add(Arrays.asList(i, j));
                    }
                }
            }
            return res;
        }

        private void dfs(int i, int j, int expectMark) {
            if ((mark[i][j] & expectMark) != 0) {
                return;
            }
            mark[i][j] |= expectMark;
            for (int[] direction : directions) {
                int ni = i + direction[0];
                int nj = j + direction[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n &&
                        (mark[ni][nj] & expectMark) == 0 && heights[ni][nj] >= heights[i][j]) {
                    dfs(ni, nj, expectMark);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}