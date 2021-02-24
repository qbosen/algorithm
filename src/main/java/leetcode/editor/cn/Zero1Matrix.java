package leetcode.editor.cn;
// 01 矩阵
// 542
// [[0,0,0],[0,1,0],[0,0,0]]

import org.junit.Assert;
import util.IntUtil;

import java.util.Arrays;

public class Zero1Matrix {
    public static void run(Solution solution, String expect, String matrix) {
        int[][] matrix_ = IntUtil.parse2DIntArray(matrix);
        int[][] result = solution.updateMatrix(matrix_);
        System.out.println(expect + "=" + Arrays.deepToString(result));
    }

    public static void main(String[] args) {
        Solution solution = new Zero1Matrix().new Solution();
        run(solution, "[[0,0,0],[0,1,0],[0,0,0]]", "[[0,0,0],[0,1,0],[0,0,0]]");
        run(solution, "[[0,0,0],[0,1,0],[1,2,1]]", "[[0,0,0],[0,1,0],[1,1,1]]");

        String input = "[[1,1,0,0,1,0,0,1,1,0],[1,0,0,1,0,1,1,1,1,1],[1,1,1,0,0,1,1,1,1,0],[0,1,1,1,0,1,1,1,1,1],[0,0,1,1,1,1,1,1,1,0],[1,1,1,1,1,1,0,1,1,1],[0,1,1,1,1,1,1,0,0,1],[1,1,1,1,1,0,0,1,1,1],[0,1,0,1,1,0,1,1,1,1],[1,1,1,0,1,0,1,1,1,1]]";
        String longExpect = "[[2, 1, 0, 0, 1, 0, 0, 1, 1, 0], [1, 0, 0, 1, 0, 1, 1, 2, 2, 1], [1, 1, 1, 0, 0, 1, 2, 2, 1, 0], [0, 1, 2, 1, 0, 1, 2, 3, 2, 1], [0, 0, 1, 2, 1, 2, 1, 2, 1, 0], [1, 1, 2, 3, 2, 1, 0, 1, 1, 1], [0, 1, 2, 3, 2, 1, 1, 0, 0, 1], [1, 2, 1, 2, 1, 0, 0, 1, 1, 2], [0, 1, 0, 1, 1, 0, 1, 2, 2, 3], [1, 2, 1, 0, 1, 0, 1, 2, 3, 4]]";
        Assert.assertArrayEquals(IntUtil.parse2DIntArray(longExpect), solution.updateMatrix(IntUtil.parse2DIntArray(input)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            int R = matrix.length;
            int C = matrix[0].length;
            int[][] dp = new int[R][C];
            // 初始化，避免溢出
            final int BIG = Integer.MAX_VALUE >>> 2;
            // 从左上 往 右下遍历，状态由 左/上决定
            for (int i = 0; i < R; i++) {
                Arrays.fill(dp[i], BIG);
                for (int j = 0; j < C; j++) {
                    if (matrix[i][j] == 0) {
                        dp[i][j] = 0;
                        continue;
                    }

                    if (i - 1 >= 0) { //上
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    }
                    if (j - 1 >= 0) { //左
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    }
                }
            }
            // 从右下往左上走
            for (int i = R - 1; i >= 0; i--) {
                for (int j = C - 1; j >= 0; j--) {
                    if (i + 1 < R) { //下
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    }
                    if (j + 1 < C) { //右
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                    }
                }
            }

            return dp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}