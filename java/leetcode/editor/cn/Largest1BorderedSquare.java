package leetcode.editor.cn;

//[1139] 最大的以 1 为边界的正方形
/* [[1,1,1],[1,0,1],[1,1,1]] */
public class Largest1BorderedSquare {
    public static void main(String[] args) {
        Solution solution = new Largest1BorderedSquare().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] left = new int[m + 1][n + 1];
            int[][] up = new int[m + 1][n + 1];
            int maxBorder = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (grid[i - 1][j - 1] == 1) {
                        left[i][j] = left[i][j - 1] + 1;
                        up[i][j] = up[i - 1][j] + 1;
                        int border = Math.min(left[i][j], up[i][j]);
                        while (left[i - border + 1][j] < border || up[i][j - border + 1] < border) {
                            border--;
                        }
                        maxBorder = Math.max(maxBorder, border);
                    }
                }
            }
            return maxBorder * maxBorder;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}