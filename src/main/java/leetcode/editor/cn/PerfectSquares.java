package leetcode.editor.cn;

public class PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new PerfectSquares().new Solution();
        System.out.println(solution.numSquares(12));
        System.out.println(solution.numSquares(13));
        System.out.println(solution.numSquares(16));
        System.out.println(solution.numSquares(17));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            for (int i = 1, sq = 1; sq <= n; ++i, sq = i * i) {
                dp[sq] = 1;
            }

            // n是平方数
            if (dp[n] == 1) {
                return 1;
            }

            for (int j = 2; j < n + 1; j++) {
                if (dp[j] != 0) continue;
                int minDp = Integer.MAX_VALUE;
                // 遍历比j小的平方数，找到最小的 dp[n-dbk]
                for (int k = 1, dbk = 1; dbk < j; ++k, dbk = k * k) {
                    if (dp[j - dbk] < minDp)
                        minDp = dp[j - dbk];
                }
                // dp[n] = min{dp[n-k]} + 1
                dp[j] = minDp + 1;
            }
            return dp[n];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}