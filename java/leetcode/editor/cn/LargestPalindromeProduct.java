package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[479] 最大回文数乘积
/* 2 */
public class LargestPalindromeProduct {
    public static void main(String[] args) {
        Solution solution = new LargestPalindromeProduct().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int MOD = 1337;

        public int largestPalindrome(int n) {
            if (n == 1) {
                return 9;
            }
            int upper = (int) Math.pow(10, n) - 1, lower = (int) Math.pow(10, n - 1) - 1;
            for (int i = upper; i > lower; i--) {
                long l = i, r = 0;
                long k = i;
                while (k != 0) {
                    r = r * 10 + k % 10;
                    k /= 10;
                    l *= 10;
                }
                long curr = l + r;
                for (long j = upper; j * j >= curr; j--) {
                    if (curr % j == 0) {
                        return (int) (curr % MOD);
                    }
                }
            }
            return -1;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}