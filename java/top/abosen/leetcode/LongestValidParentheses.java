package top.abosen.leetcode;

//[32] 最长有效括号
/* "(()" */
public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            int[] dp = new int[s.length()];
            int ans = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                        dp[i] = dp[i - 1] + ((i - 2 - dp[i - 1]) >= 0 ? dp[i - 2 - dp[i - 1]] : 0) + 2;
                    }
                    ans = Math.max(ans, dp[i]);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}