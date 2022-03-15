package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[2044] 统计按位或能得到最大值的子集数目
/* [3,1] */
public class CountNumberOfMaximumBitwiseOrSubsets {
    public static void main(String[] args) {
        Solution solution = new CountNumberOfMaximumBitwiseOrSubsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countMaxOrSubsets(int[] nums) {
            int n = nums.length;
            int max = 0, res = 0;

            // 枚举所有
            for (int i = 0; i < 1 << n; i++) {
                int cur = 0;
                // bits(i) 为1的 保留
                for (int j = 0; j < n; j++) {
                    if (((i >> j) & 1) == 1) {
                        cur |= nums[j];
                    }
                }

                if (cur > max) {
                    max = cur;
                    res = 1;
                } else if (cur == max) {
                    res++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}