package top.abosen.leetcode;

import java.util.*;

import top.abosen.leetcode.struct.*;

//[441] 排列硬币
/* 5 */
public class ArrangingCoins {
    public static void main(String[] args) {
        Solution solution = new ArrangingCoins().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arrangeCoins(int n) {
            return (int) ((Math.sqrt((long) 8 * n + 1) - 1) / 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}