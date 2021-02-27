package leetcode.editor.cn;

//867 转置矩阵
/* [[1,2,3],[4,5,6],[7,8,9]] */
public class TransposeMatrix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] transpose(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            if (m == n) {
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        int t = matrix[i][j];
                        matrix[i][j] = matrix[j][i];
                        matrix[j][i] = t;
                    }
                }
                return matrix;
            }
            int[][] res = new int[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res[j][i] = matrix[i][j];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}