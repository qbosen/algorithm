package top.abosen.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

//[32] 最长有效括号
/* "(()" */
public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses_dp(String s) {
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

        public int longestValidParentheses(String s) {
            Deque<Integer> deque = new ArrayDeque<>();
            deque.push(-1);
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    deque.push(i);
                } else {
                    deque.pop();
                    if (deque.isEmpty()) {
                        deque.push(i);
                    } else {
                        ans = Math.max(ans, i - deque.peek());
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}