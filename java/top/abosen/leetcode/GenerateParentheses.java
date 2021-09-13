package top.abosen.leetcode;

import java.util.ArrayList;
import java.util.List;

//[22] 括号生成
/* 3 */
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            char[] data = new char[2 * n];
            List<String> ans = new ArrayList<>();
            backtracking(ans, data, 0, n, 0);
            return ans;
        }

        private void backtracking(List<String> ans, char[] data, int idx, int l, int r) {
            if (l == 0 && r == 0) {
                ans.add(new String(data));
                return;
            }
            if (l > 0) {
                data[idx] = '(';
                backtracking(ans, data, idx + 1, l - 1, r + 1);
            }
            if (r > 0) {
                data[idx] = ')';
                backtracking(ans, data, idx + 1, l, r - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}