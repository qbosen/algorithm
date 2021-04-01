package leetcode.editor.cn;

// 1006 笨阶乘
/* 4 */

public class ClumsyFactorial {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int clumsy(int N) {
            if (N == 1) {
                return 1;
            } else if (N == 2) {
                return 2;
            } else if (N == 3) {
                return 6;
            } else if (N == 4) {
                return 7;
            }

            if (N % 4 == 0) {
                return N + 1;
            } else if (N % 4 <= 2) {
                return N + 2;
            } else {
                return N - 1;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}