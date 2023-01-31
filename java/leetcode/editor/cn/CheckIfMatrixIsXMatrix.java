package leetcode.editor.cn;

//[2319] 判断矩阵是否是一个 X 矩阵
/* [[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]] */
public class CheckIfMatrixIsXMatrix {
    public static void main(String[] args) {
        Solution solution = new CheckIfMatrixIsXMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkXMatrix(int[][] grid) {
            int n = grid.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j || i == (n - j - 1)) {
                        if (grid[i][j] == 0) return false;
                    } else {
                        if (grid[i][j] != 0) return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}