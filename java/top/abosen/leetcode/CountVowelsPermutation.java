package top.abosen.leetcode;

import java.util.Arrays;

//[1220] 统计元音字母序列的数目
/* 1 */
public class CountVowelsPermutation {
    public static void main(String[] args) {
        Solution solution = new CountVowelsPermutation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countVowelPermutation(int n) {
            long MOD = 1_000_000_007;
            long[] dp = new long[5];
            long[] ndp = new long[5];
            Arrays.fill(dp, 1);

            /**
             * target   from
             * a        e i u
             * e        a i
             * i        e o
             * o        i
             * u        i o
             */

            for (int i = 2; i <= n; i++) {
                ndp[0] = (dp[1] + dp[2] + dp[4]) % MOD;
                ndp[1] = (dp[0] + dp[2]) % MOD;
                ndp[2] = (dp[1] + dp[3]) % MOD;
                ndp[3] = dp[2];
                ndp[4] = (dp[2] + dp[3]) % MOD;

                System.arraycopy(ndp, 0, dp, 0, 5);
            }

            long res = 0;
            for (long c : dp) {
                res = (res + c) % MOD;
            }
            return (int) res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}