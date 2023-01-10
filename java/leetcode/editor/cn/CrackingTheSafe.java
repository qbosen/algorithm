package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//[753] 破解保险箱
/* 1,2 */
public class CrackingTheSafe {
    public static void main(String[] args) {
        Solution solution = new CrackingTheSafe().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        StringBuilder sb = new StringBuilder();
        int n, k, mod;
        Set<Integer> vis = new HashSet<>();

        public String crackSafe(int N, int K) {
            n = N;
            k = K;
            mod = (int) Math.pow(10, n - 1);
            dfs(0);
            sb.append("0".repeat(n - 1));
            return sb.toString();
        }

        void dfs(int u) {
            for (int i = 0; i < k; i++) {
                int v = u * 10 + i;
                if (vis.contains(v)) continue;
                vis.add(v);
                dfs(v % mod);
                sb.append(i);
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}