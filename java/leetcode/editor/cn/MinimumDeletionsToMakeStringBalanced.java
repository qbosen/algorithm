package leetcode.editor.cn;

//[1653] 使字符串平衡的最少删除次数
/* "aababbab" */
public class MinimumDeletionsToMakeStringBalanced {
    public static void main(String[] args) {
        Solution solution = new MinimumDeletionsToMakeStringBalanced().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDeletions(String s) {
            int n = s.length();
            int[] l2r_a = new int[n + 1];
            int[] r2l_b = new int[n + 1];
            for (int i = 0; i < n; i++) {
                l2r_a[i + 1] = l2r_a[i] + (s.charAt(i) == 'a' ? 1 : 0);
            }
            for (int i = n - 1; i >= 0; i--) {
                r2l_b[i] = r2l_b[i + 1] + (s.charAt(i) == 'b' ? 1 : 0);
            }
            int maxL = 0;
            for (int i = 0; i <= n; i++) {
                maxL = Math.max(maxL, l2r_a[i] + r2l_b[i]);
            }
            return n - maxL;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}