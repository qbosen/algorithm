package leetcode.editor.cn;

//[面试题 01.08] 零矩阵
/* [[1,1,1],[1,0,1],[1,1,1]] */
public class ZeroMatrixLcci {
    public static void main(String[] args) {
        Solution solution = new ZeroMatrixLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            boolean[] zr = new boolean[m], zc = new boolean[n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        zr[i] = true;
                        zc[j] = true;
                    }
                }
            }


            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (zr[i] || zc[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}