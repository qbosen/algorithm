package leetcode.editor.cn;
// 编辑距离
// 72
// "horse" "ros"

public class EditDistance {
    public static void run(Solution solution, int expect, String word1, String word2) {
        String word1_ = word1;
        String word2_ = word2;
        int result = solution.minDistance(word1_, word2_);
        System.out.println(expect + "=" + result);
    }

    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
        run(solution, 3, "horse", "ros");
        run(solution, 5, "intention", "execution");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int n1 = word1.length();
            int n2 = word2.length();
            if (n1 * n2 == 0) {     // 有一个串长度为0
                return n1 + n2;
            }
            int dp[][] = new int[n1 + 1][n2 + 1];
            // 初始化
            for (int i = 0; i < n1 + 1; i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j < n2 + 1; j++) {
                dp[0][j] = j;
            }

            //`D[i][j] = min{D[i-1][j] + 1, D[i][j-1] + 1, D[i-1][j-1] + lastCharSame?0:1}`
            for (int i = 1; i < n1 + 1; i++) {
                for (int j = 1; j < n2 + 1; j++) {
                    int insertLeft = dp[i][j - 1] + 1;
                    int insertRight = dp[i - 1][j] + 1;
                    int modify = dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
                    dp[i][j] = Math.min(Math.min(insertLeft,insertRight), modify);
                }
            }
            return dp[n1][n2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}