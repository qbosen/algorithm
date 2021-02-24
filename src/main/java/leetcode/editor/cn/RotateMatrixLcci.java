package leetcode.editor.cn;
// 旋转矩阵
// 面试题 01.07
// [[1,2,3],[4,5,6],[7,8,9]]

import util.IntUtil;

import java.util.Arrays;

public class RotateMatrixLcci {
    public static void run(Solution solution, String expect, String matrix) {
        int[][] matrix_ = IntUtil.parse2DIntArray(matrix);
        solution.rotate(matrix_);
        System.out.println(expect + "=" + Arrays.deepToString(matrix_));
    }

    public static void main(String[] args) {
        Solution solution = new RotateMatrixLcci().new Solution();
        run(solution, "[[7,4,1],[8,5,2],[9,6,3]]", "[[1,2,3],[4,5,6],[7,8,9]]");
        run(solution, "[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]", "[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            int N = matrix.length;
            for (int i = 0; i < (N >> 1); i++) {
                for (int j = 0; j < ((N + 1) >> 1); j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[N - j - 1][i];
                    matrix[N - j - 1][i] = matrix[N - i - 1][N - j - 1];
                    matrix[N - i - 1][N - j - 1] = matrix[j][N - i - 1];
                    matrix[j][N - i - 1] = tmp;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}