package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[1706] 球会落何处
/* [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]] */
public class WhereWillTheBallFall {
    public static void main(String[] args) {
        Solution solution = new WhereWillTheBallFall().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findBall(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                // 每个球的初始位置
                int col = i;
                for (int[] row : grid) {
                    int nextC = col + row[col];
                    if (nextC < 0 || nextC >= n || row[nextC] != row[col]) {
                        col = -1;
                        break;
                    }
                    col = nextC;
                }
                res[i] = col;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}