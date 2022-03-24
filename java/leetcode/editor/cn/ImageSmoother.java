package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[661] 图片平滑器
/* [[1,1,1],[1,0,1],[1,1,1]] */
public class ImageSmoother {
    public static void main(String[] args) {
        Solution solution = new ImageSmoother().new Solution();
        System.out.println(Arrays.deepToString(solution.imageSmoother(new int[][]{{100, 200, 100}, {200, 50, 200}, {100, 200, 100}})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] imageSmoother(int[][] img) {
            int m = img.length, n = img[0].length;
            int[][] sum = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + img[i][j];
                }
            }

            int[][] res = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int t = i == 0 ? 0 : i - 1, b = i == m - 1 ? m - 1 : i + 1;
                    int l = j == 0 ? 0 : j - 1, r = j == n - 1 ? n - 1 : j + 1;
                    int region = sum[b + 1][r + 1] - sum[b + 1][l] - sum[t][r + 1] + sum[t][l];
                    res[i][j] = region / ((r - l + 1) * (b - t + 1));
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}