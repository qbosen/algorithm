package leetcode.editor.cn;

//[498] 对角线遍历
/* [[1,2,3],[4,5,6],[7,8,9]] */
public class DiagonalTraverse {
    public static void main(String[] args) {
        Solution solution = new DiagonalTraverse().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            int i = 0, j = 0;
            boolean l2r = true;
            int[] res = new int[m * n];
            res[0] = mat[0][0];
            for (int idx = 1; idx < res.length; idx++) {
                // region move
                if (l2r) {
                    i--;
                    j++;
                    if (i < 0 || j >= n) {
                        // 从左往右触碰边界了,先向下一格,不合法再多走一步
                        i++;
                        l2r = false;
                        if (j >= n) {
                            i++;
                            j--;
                        }
                    }
                } else {
                    i++;
                    j--;
                    if (i >= m || j < 0) {
                        j++;
                        l2r = true;
                        if (i >= m) {
                            i--;
                            j++;
                        }
                    }
                }
                //endregion
                res[idx] = mat[i][j];
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}