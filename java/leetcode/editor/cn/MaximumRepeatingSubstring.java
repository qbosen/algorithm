package leetcode.editor.cn;

//[1668] 最大重复子字符串
/* "ababc","ab" */
public class MaximumRepeatingSubstring {
    public static void main(String[] args) {
        Solution solution = new MaximumRepeatingSubstring().new Solution();
        solution.maxRepeating("ababc", "ab");
        System.out.println(solution.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxRepeating(String sequence, String word) {
            int n = sequence.length(), m = word.length();
            if (n < m) {
                return 0;
            }

            int[] dp = new int[n];
            int res = 0;
            for (int i = m - 1; i < n; i++) {
                boolean valid = true;
                for (int j = 0; j < m; j++) {
                    if (sequence.charAt(i - m + j + 1) != word.charAt(j)) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    dp[i] = (i - m >= 0 ? dp[i - m] : 0) + 1;
                    res = Math.max(res, dp[i]);
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}