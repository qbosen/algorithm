package leetcode.editor.cn;

//[1582] 二进制矩阵中的特殊位置
/* [[1,0,0],[0,0,1],[1,0,0]] */
public class SpecialPositionsInABinaryMatrix {
    public static void main(String[] args) {
        Solution solution = new SpecialPositionsInABinaryMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSpecial(int[][] mat) {
            int n = mat.length, m = mat[0].length;
            int[] r = new int[n], c = new int[m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    r[i] += mat[i][j];
                    c[j] += mat[i][j];
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] == 1 && r[i] == 1 && c[j] == 1){
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}