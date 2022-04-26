package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[883] 三维形体投影面积
/* [[1,2],[3,4]] */
public class ProjectionAreaOf3dShapes {
    public static void main(String[] args) {
        Solution solution = new ProjectionAreaOf3dShapes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int projectionArea(int[][] grid) {
            int res = 0;
            int n = grid.length;
            for (int i = 0; i < n; i++) {
                int m1 = 0, m2 = 0;
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] != 0) {
                        res++;
                    }
                    m1 = Math.max(m1, grid[i][j]);
                    m2 = Math.max(m2, grid[j][i]);
                }
                res = res + m1 + m2;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}