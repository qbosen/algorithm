package leetcode.editor.cn;

import java.util.Arrays;

//115 不同的子序列
/* "rabbbit","rabbit" */
public class DistinctSubsequences {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDistinct(String s, String t) {
            int m = t.length();
            int n = s.length();
            int[][] dp = new int[m + 1][n + 1];
            Arrays.fill(dp[0], 1);

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i][j - 1];
                    if (t.charAt(i - 1) == s.charAt(j - 1))
                        dp[i][j] += dp[i - 1][j - 1];
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}