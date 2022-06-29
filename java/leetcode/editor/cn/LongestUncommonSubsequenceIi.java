package leetcode.editor.cn;

//[522] 最长特殊序列 II
/* ["aba","cdc","eae"] */
public class LongestUncommonSubsequenceIi {
    public static void main(String[] args) {
        Solution solution = new LongestUncommonSubsequenceIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLUSlength(String[] strs) {
            int res = -1;
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() <= res) {
                    continue;
                }

                boolean ok = true;
                for (int j = 0; ok && j < strs.length; j++) {
                    if (i == j) continue;
                    if (check(strs[i], strs[j])) {
                        ok = false;
                    }
                }

                if (ok) res = strs[i].length();
            }
            return res;
        }

        // s1是否是s2的子序列
        private boolean check(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            if (m > n) return false;
            int[][] f = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        f[i][j] = f[i - 1][j - 1] + 1;
                    } else {
                        f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                    }
                    // 最长公共字串有s1那么长
                    if (f[i][j] == m) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}