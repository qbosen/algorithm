package top.abosen.leetcode;

//678 有效的括号字符串
public class ValidParenthesisString {
    public static void main(String[] args) {
        Solution solution = new ValidParenthesisString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkValidString(String s) {
            int n = s.length();
            boolean[][] f = new boolean[n + 1][n + 1];
            f[0][0] = true;
            for (int i = 1; i <= n; i++) {
                char c = s.charAt(i - 1);
                for (int j = 0; j <= i; j++) {
                    if (c == '(') {
                        if (j - 1 >= 0) f[i][j] = f[i - 1][j - 1];
                    } else if (c == ')') {
                        if (j + 1 <= i) f[i][j] = f[i - 1][j + 1];
                    } else {
                        f[i][j] = f[i - 1][j];
                        if (j - 1 >= 0) f[i][j] |= f[i - 1][j - 1];
                        if (j + 1 <= i) f[i][j] |= f[i - 1][j + 1];
                    }
                }
            }
            return f[n][0];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}