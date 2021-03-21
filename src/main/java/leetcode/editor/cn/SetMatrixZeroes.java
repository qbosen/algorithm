package leetcode.editor.cn;

// 73 矩阵置零
/* [[1,1,1],[1,0,1],[1,1,1]] */

public class SetMatrixZeroes {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            boolean topZero = false;
            boolean leftZero = false;
            int m = matrix.length;
            int n = matrix[0].length;

            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == 0) {
                    leftZero = true;
                    break;
                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[0][j] == 0) {
                    topZero = true;
                    break;
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            // 标记完成
            for (int i = 1; i < m; i++) {
                if (matrix[i][0] == 0) {
                    for (int j = 1; j < n; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0) {
                    for (int i = 1; i < m; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            // 清理标记
            if (topZero) {
                for (int j = 0; j < n; j++) {
                    matrix[0][j] = 0;
                }
            }


            if (leftZero) {
                for (int i = 0; i < m; i++) {
                    matrix[i][0] = 0;
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}