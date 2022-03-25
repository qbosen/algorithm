package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[172] 阶乘后的零
/* 3 */
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        Solution solution = new FactorialTrailingZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trailingZeroes(int n) {
            return n < 5 ? 0 : n / 5 + trailingZeroes(n / 5);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}