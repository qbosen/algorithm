package leetcode.editor.cn;

import java.util.Arrays;

//[462] 最少移动次数使数组元素相等 II
/* [1,2,3] */
public class MinimumMovesToEqualArrayElementsIi {
    public static void main(String[] args) {
        Solution solution = new MinimumMovesToEqualArrayElementsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMoves2(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length, t = nums[(n - 1) / 2], ans = 0;
            for (int i : nums) {
                ans += Math.abs(t - i);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}