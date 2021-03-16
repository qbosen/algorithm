package leetcode.editor.cn;

//59 螺旋矩阵 II
/* 3 */
public class SpiralMatrixIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            int left = 0, right = n - 1, top = 0, bottom = n - 1;
            int i = 1;
            while (left <= right && top <= bottom) {
                for (int c = left; c <= right; c++) {
                    res[top][c] = i++;
                }
                for (int r = top + 1; r <= bottom; r++) {
                    res[r][right] = i++;
                }

                if (left < right && top < bottom) {
                    for (int c = right - 1; c >= left; c--) {
                        res[bottom][c] = i++;
                    }
                    for (int r = bottom - 1; r > top; r--) {
                        res[r][left] = i++;
                    }
                }
                left++;
                right--;
                top++;
                bottom--;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}