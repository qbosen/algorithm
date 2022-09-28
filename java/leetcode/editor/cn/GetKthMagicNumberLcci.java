package leetcode.editor.cn;

//[面试题 17.09] 第 k 个数
/* 1 */
public class GetKthMagicNumberLcci {
    public static void main(String[] args) {
        Solution solution = new GetKthMagicNumberLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getKthMagicNumber(int k) {
            int[] ans = new int[k + 1];
            ans[1] = 1;
            int i3 = 1, i5 = 1, i7 = 1;

            for (int i = 2; i <= k; i++) {
                int a = ans[i3] * 3, b = ans[i5] * 5, c = ans[i7] * 7;
                int next = Math.min(a, Math.min(b, c));
                if (a == next) i3++;
                if (b == next) i5++;
                if (c == next) i7++;
                ans[i] = next;
            }
            return ans[k];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}