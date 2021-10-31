package top.abosen.leetcode;

import java.util.*;

import top.abosen.leetcode.struct.*;

//[260] 只出现一次的数字 III
/* [1,2,1,3,2,5] */
public class SingleNumberIii {
    public static void main(String[] args) {
        Solution solution = new SingleNumberIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumber(int[] nums) {
            int res = 0;
            for (int num : nums) {
                res ^= num;
            }
            int lsb = (res == Integer.MIN_VALUE ? res : res & (-res));
            int type1 = 0, type2 = 0;
            for (int num : nums) {
                if ((num & lsb) != 0) {
                    type1 ^= num;
                } else {
                    type2 ^= num;
                }
            }
            return new int[]{type1, type2};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}