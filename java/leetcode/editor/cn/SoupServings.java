package leetcode.editor.cn;

//[808] 分汤
/* 50 */
public class SoupServings {
    public static void main(String[] args) {
        Solution solution = new SoupServings().new Solution();
        solution.cal();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double soupServings(int n) {
            n = n % 25 == 0 ? n / 25 : n / 25 + 1;
            if (n >= 179) return 1.0;
            return soupServings_(n);
        }

        public double soupServings_(int n) {
            double[][] dp = new double[n + 1][n + 1];
            dp[0][0] = 0.5;
            for (int i = 1; i <= n; i++) {
                dp[0][i] = 1.0;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = 0.25 * (dp[Math.max(0, i - 4)][j] +
                            dp[Math.max(0, i - 3)][Math.max(0, j - 1)] +
                            dp[Math.max(0, i - 2)][Math.max(0, j - 2)] +
                            dp[Math.max(0, i - 1)][Math.max(0, j - 3)]);
                }
            }

            return dp[n][n];
        }

        public int cal() {
            int M = (int) 10e9;
            for (int i = 1; i < M; i++) {
                double acc = soupServings_(i);
                System.out.printf("%d \t > %s%n", i, acc);
                if (acc > 0.99999d) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}