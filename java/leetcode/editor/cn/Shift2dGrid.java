package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//[1260] 二维网格迁移
/* [[1,2,3],[4,5,6],[7,8,9]],1 */
public class Shift2dGrid {
    public static void main(String[] args) {
        Solution solution = new Shift2dGrid().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> shiftGrid(int[][] g, int k) {
            int n = g.length, m = g[0].length;
            int[][] mat = new int[n][m];
            for (int i = 0; i < m; i++) {
                int tcol = (i + k) % m, trow = ((i + k) / m) % n, idx = 0;
                while (idx != n) mat[(trow++) % n][tcol] = g[idx++][i];
            }
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<Integer> alist = new ArrayList<>();
                for (int j = 0; j < m; j++) alist.add(mat[i][j]);
                ans.add(alist);
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}