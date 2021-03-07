package leetcode.editor.cn;

// 131 分割回文串
/* "aab" */

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] f;
        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int n;

        public List<List<String>> partition(String s) {
            n = s.length();
            f = new int[n][n];
            dfs(s, 0);
            return res;
        }

        public void dfs(String s, int i) {
            if (i == n) {
                res.add(new ArrayList<>(ans));
                return;
            }

            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j) == 1) {
                    ans.add(s.substring(i, j + 1));
                    dfs(s, j + 1);
                    ans.remove(ans.size() - 1);
                }
            }
        }

        private int isPalindrome(String s, int a, int b) {
            // 0未遍历，1是回文，-1不是回文
            if (f[a][b] != 0) {
                return f[a][b];
            }

            if (a >= b) {
                f[a][b] = 1;
            } else if (s.charAt(a) == s.charAt(b)) {
                f[a][b] = isPalindrome(s, a + 1, b - 1);
            } else {
                f[a][b] = -1;
            }
            return f[a][b];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}