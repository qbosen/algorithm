package leetcode.editor.cn;

//132 分割回文串 II
/* "aab" */
public class PalindromePartitioningIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n;
        int f[][];
        int[] dp;

        public int minCut(String s) {
            n = s.length();
            f = new int[n][n];
            dp = new int[n];

            for (int i = 1; i < n; i++) {
                if (isPalindrome(s, 0, i) == 1) {
                    dp[i] = 0;
                    continue;
                }
                int count = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (isPalindrome(s, j + 1, i) == 1) {
                        count = Math.min(count, dp[j]);
                    }
                }
                dp[i] = count + 1;
            }
            return dp[n - 1];
        }

        public int isPalindrome(String s, int a, int b) {
            if (f[a][b] != 0) return f[a][b];
            if (a >= b) {
                f[a][b] = 1;
            } else if (s.charAt(a) == s.charAt(b) && isPalindrome(s, a + 1, b - 1) == 1) {
                f[a][b] = 1;
            } else {
                f[a][b] = -1;
            }

            return f[a][b];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}