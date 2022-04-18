package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[386] 字典序排数
/* 13 */
public class LexicographicalNumbers {
    public static void main(String[] args) {
        Solution solution = new LexicographicalNumbers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> lexicalOrder(int n) {
            List<Integer> res = new ArrayList<>(n);
            for (int i = 1; i < 10; i++) {
                dfs(i, n, res);
            }
            return res;
        }

        private void dfs(int cur, int n, List<Integer> res) {
            if (cur > n) {
                return;
            }
            res.add(cur);
            for (int i = 0; i < 10; i++) {
                dfs(cur * 10 + i, n, res);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}