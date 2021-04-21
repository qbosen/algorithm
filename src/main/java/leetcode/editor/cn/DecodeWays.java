package leetcode.editor.cn;

//91 解码方法
/* "12" */
public class DecodeWays {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            int n = s.length();
            int[] dp = new int[n + 1];
            dp[0] = 1;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != '0') {
                    dp[i + 1] += dp[i];
                }
                // 使用两个字符编码
                if (i > 0 && s.charAt(i - 1) != '0' && ((s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') <= 26)) {
                    dp[i + 1] += dp[i - 1];
                }
            }
            return dp[n];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}