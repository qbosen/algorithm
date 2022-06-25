package leetcode.editor.cn;

//[剑指 Offer II 091] 粉刷房子
/* [[17,2,17],[16,16,5],[14,3,19]] */
public class JEj789 {
    public static void main(String[] args) {
        Solution solution = new JEj789().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCost(int[][] cs) {
            int n = cs.length;
            int a = cs[0][0], b = cs[0][1], c = cs[0][2];
            for (int i = 1; i < n; i++) {
                int d = Math.min(b, c) + cs[i][0];
                int e = Math.min(a, c) + cs[i][1];
                int f = Math.min(a, b) + cs[i][2];
                a = d;
                b = e;
                c = f;
            }
            return Math.min(a, Math.min(b, c));
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}