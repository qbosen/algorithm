package leetcode.editor.cn;

import java.util.Arrays;

//132 分割回文串 II
/* "aab" */
public class PalindromePartitioningIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCut(String s) {
            int n = s.length();
            int[] dp = new int[n];
            Arrays.fill(dp, n - 1);

            for (int i = 0; i < n; i++) {
                palindromic(s, i, i, dp);
                palindromic(s, i, i + 1, dp);
            }
            return dp[n - 1];
        }

        public void palindromic(String s, int i, int j, int[] dp) {
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                int cur = i == 0 ? 0 : dp[i - 1] + 1;
                if (cur < dp[j]) {
                    dp[j] = cur;
                }
                i--;
                j++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}