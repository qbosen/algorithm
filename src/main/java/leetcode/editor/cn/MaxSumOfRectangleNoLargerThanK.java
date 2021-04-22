package leetcode.editor.cn;

import java.util.TreeSet;

//363 矩形区域不超过 K 的最大数值和
/* [[1,0,1],[0,-2,3]],2 */
public class MaxSumOfRectangleNoLargerThanK {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] sum = new int[m + 1][n + 1];

            // 前缀和
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }

            int ans = Integer.MIN_VALUE;

            for (int top = 1; top <= m; top++) {   // 枚举上边界
                for (int bot = top; bot <= m; bot++) {   // 枚举下边界
                    // 所有遍历 右边界 时的 sum
                    TreeSet<Integer> ts = new TreeSet<>();
                    ts.add(0);

                    for (int r = 1; r <= n; r++) {
                        // 左边界0时的sum
                        int right = sum[bot][r] - sum[top - 1][r];
                        // 左边界 在 已经遍历过的右边界中
                        // 找到最大的left 满足 right-left <= k
                        Integer left = ts.ceiling(right - k);
                        if (left != null) {
                            ans = Math.max(ans, right - left);
                        }
                        ts.add(right);
                    }
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}