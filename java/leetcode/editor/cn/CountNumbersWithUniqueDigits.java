package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[357] 统计各位数字都不同的数字个数
/* 2 */
public class CountNumbersWithUniqueDigits {
    public static void main(String[] args) {
        Solution solution = new CountNumbersWithUniqueDigits().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) return 1;
            if (n == 1) return 10;
            int dp = 9;
            int res = 10;

            for (int i = 2; i <= n && i <= 10; i++) {
                dp *= (11 - i);
                res += dp;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}