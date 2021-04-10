package leetcode.editor.cn;

// 263 丑数
/* 6 */

public class UglyNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUgly(int n) {
            if (n <= 0) return false;
            int[] factors = {2, 3, 5};
            for (int factor : factors) {
                while (n % factor == 0) {
                    n = n / factor;
                }
            }
            return n == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}