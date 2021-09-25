  package top.abosen.leetcode;
  //583 两个字符串的删除操作
  public class DeleteOperationForTwoStrings{
      public static void main(String[] args) {
           Solution solution = new DeleteOperationForTwoStrings().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public int minDistance(String word1, String word2) {
              int m = word1.length(), n = word2.length();
              int[][] dp = new int[m + 1][n + 1];
              for (int i = 1; i <= m; i++) {
                  dp[i][0] = i;
              }
              for (int j = 1; j <= n; j++) {
                  dp[0][j] = j;
              }
              for (int i = 1; i <= m; i++) {
                  char c1 = word1.charAt(i - 1);
                  for (int j = 1; j <= n; j++) {
                      char c2 = word2.charAt(j - 1);
                      if (c1 == c2) {
                          dp[i][j] = dp[i - 1][j - 1];
                      } else {
                          dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                      }
                  }
              }
              return dp[m][n];
          }
      }

//leetcode submit region end(Prohibit modification and deletion)

  }