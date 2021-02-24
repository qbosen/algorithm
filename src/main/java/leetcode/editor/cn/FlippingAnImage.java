package leetcode.editor.cn;

//832 翻转图像
/* [[1,1,0],[1,0,1],[0,0,0]] */
public class FlippingAnImage {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] flipAndInvertImage(int[][] A) {
            int n = A[0].length;
            for (int[] row : A) {
                for (int i = 0; i < (n + 1) / 2; i++) {
                    int cur = row[i];
                    row[i] = row[n - i - 1] ^ 1;
                    row[n - i - 1] = cur ^ 1;
                }
            }
            return A;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}