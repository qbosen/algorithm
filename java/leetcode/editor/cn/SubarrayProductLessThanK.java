package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[713] 乘积小于 K 的子数组
/* [10,5,2,6],100 */
public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        Solution solution = new SubarrayProductLessThanK().new Solution();
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{57, 44, 92, 28, 66, 60, 37, 33, 52, 38, 29, 76, 8, 75, 22}, 18));
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (k <= 1) return 0;
            int l = 0, r = 0, res = 0;
            long product = 1;
            while (r < nums.length) {
                product = product * nums[r];
                while (product >= k) {
                    product /= nums[l++];
                }
                res += r - l + 1;
                r++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}